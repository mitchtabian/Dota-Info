package com.codingwithmitch.topplayerservice

import com.codingwithmitch.player.Player
import com.codingwithmitch.player.Profile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopPlayerDto(

    @SerialName("solo_competitive_rank")
    val soloCompetitiveRank: Int? = null,

    @SerialName("profile")
    val profile: ProfileDto? = null,

    @SerialName("leaderboard_rank")
    val leaderBoardRank: Int? = null,

    @SerialName("competitive_rank")
    val competitiveRank: Int? = null,

    @SerialName("mmr_estimate")
    val mmrEstimate: MmrEstimateDto? = null,
)

fun TopPlayerDto.toPlayer(): Player? {
    if(profile?.accountId == null){ // need the accountId to cache it
        return null
    }
    return Player(
        soloCompetitiveRank = soloCompetitiveRank,
        profile = Profile(
            accountId = profile.accountId,
            personaName = profile.personaName,
            name = profile.name,
            steamId = profile.steamId,
            avatar = profile.avatar,
            avatarMedium = profile.avatarMedium,
            avatarFull = profile.avatarFull,
            profileUrl = profile.profileUrl,
            lastLogin = profile.lastLogin,
            locCountryCode = profile.locCountryCode,
        ),
        leaderBoardRank = leaderBoardRank,
        competitiveRank = competitiveRank,
        mmrEstimate = mmrEstimate?.estimate
    )
}













