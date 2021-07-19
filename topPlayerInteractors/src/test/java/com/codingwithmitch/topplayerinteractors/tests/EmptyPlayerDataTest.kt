package com.codingwithmitch.topplayerinteractors.tests

import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.player.Player
import com.codingwithmitch.topplayerinteractors.GetPlayers
import com.codingwithmitch.topplayerinteractors.responses.Players
import com.codingwithmitch.topplayerservice.TopPlayerServiceImpl
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.http.*
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class EmptyPlayerDataTest {

    // system in test
    private lateinit var getPlayers: GetPlayers

    // dependencies
    private lateinit var httpClient: HttpClient
    private val Url.hostWithPortIfRequired: String get() = if (port == protocol.defaultPort) host else hostWithPort
    private val Url.fullUrl: String get() = "${protocol.name}://$hostWithPortIfRequired$fullPath"
    private val URL_EMPTY_PLAYER = "https://api.opendota.com/api/players/112740723"
    private val RESPONSE_EMPTY_PLAYER_ID = "[ { \"account_id\": 112740723, \"rating\": 80, \"fh_unavailable\": false } ]"

    @Before
    fun before(){
        httpClient = HttpClient(MockEngine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true // if the server sends extra fields, ignore them
                    }
                )
            }
            engine {
                addHandler { request ->
                    when (request.url.fullUrl) {
                        "https://api.opendota.com/api/playersByRank" -> {
                            val responseHeaders = headersOf(
                                "Content-Type" to listOf("application/json", "charset=utf-8")
                            )
                            respond(RESPONSE_EMPTY_PLAYER_ID, headers = responseHeaders)
                        }
                        URL_EMPTY_PLAYER -> {
                            val responseHeaders = headersOf(
                                "Content-Type" to listOf("application/json", "charset=utf-8")
                            )
                            respond(Players.emptyPlayerData, headers = responseHeaders)
                        }
                        else -> error("Unhandled ${request.url.fullUrl}")
                    }
                }
            }
        }
    }

    @Test
    fun getPlayersByRank_emptyData() = runBlocking {
        getPlayers = GetPlayers(
            service = TopPlayerServiceImpl(httpClient)
        )

        val emissions = getPlayers.execute().toList()

        // Confirm first emission is loading state
        assert(emissions[0] is DataState.Loading)
        assert(emissions[0] == DataState.Loading<List<Player>>(ProgressBarState.Loading))

        // Confirm second emission is empty list of data
        assert(emissions[1] is DataState.Data)
        assert((emissions[1] as DataState.Data).data?.size == 0)

        // Confirm loading state is IDLE
        assert(emissions[2] == DataState.Loading<List<Player>>(ProgressBarState.Idle))
    }
}













