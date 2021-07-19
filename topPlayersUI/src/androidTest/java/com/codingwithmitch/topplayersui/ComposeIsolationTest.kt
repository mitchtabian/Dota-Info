package com.codingwithmitch.topplayersui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.codingwithmitch.player.Player
import com.codingwithmitch.player.Profile
import com.codingwithmitch.topplayersui.presentation.TopPlayers
import com.codingwithmitch.topplayersui.presentation.TopPlayersState
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ComposeIsolationTest {

    @get:Rule(order = 1)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createComposeRule()

    @Test
    fun MyTest() {
        composeTestRule.setContent {
            TopPlayers(
                state = TopPlayersState(
                    players = listOf(
                        Player(
                            profile = Profile(
                                accountId = 1,
                                personaName = "Mitch Tabian"
                            )
                        )
                    )
                ),
                events = {  },
                navigateToDetailScreen = {}
            )
        }
        Thread.sleep(2000)
        assert(true)
    }
}












