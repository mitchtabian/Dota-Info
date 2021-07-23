package com.codingwithmitch.dotainfo.ui.heroList

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import coil.ImageLoader
import com.codingwithmitch.dotainfo.coil.FakeImageLoader
import com.codingwithmitch.dotainfo.data.Heros
import com.codingwithmitch.ui_herolist.ui.HeroList
import com.codingwithmitch.ui_herolist.ui.HeroListState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class HeroListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    lateinit var imageLoader: ImageLoader

    @Before
    fun setUp() {
        imageLoader = FakeImageLoader.build(context)
        val heroData = Heros.serializeHeroData(Heros.heroJsonData)
        composeTestRule.setContent {
            val state = remember{
                HeroListState(
                    heros = heroData,
                    filteredHeros = heroData,
                )
            }
            HeroList(
                state = state,
                events = {

                },
                navigateToDetailScreen = {

                },
                imageLoader = imageLoader,
            )
        }
    }

    @Test
    fun zeusIsShown() {
        composeTestRule.onNodeWithText("Zeus").assertIsDisplayed()
    }

}














