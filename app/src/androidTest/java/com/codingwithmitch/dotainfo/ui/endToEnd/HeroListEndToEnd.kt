package com.codingwithmitch.dotainfo.ui.endToEnd

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.test.platform.app.InstrumentationRegistry
import coil.ImageLoader
import com.codingwithmitch.dotainfo.coil.FakeImageLoader
import com.codingwithmitch.dotainfo.data.Heros
import com.codingwithmitch.dotainfo.ui.MainActivity
import com.codingwithmitch.dotainfo.ui.addHeroDetail
import com.codingwithmitch.dotainfo.ui.addHeroList
import com.codingwithmitch.dotainfo.ui.navigation.Screen
import com.codingwithmitch.dotainfo.ui.theme.DotaInfoTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@HiltAndroidTest
class HeroListEndToEnd {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val imageLoader: ImageLoader = FakeImageLoader.build(context)
    private val heroData = Heros.serializeHeroData(Heros.heroJsonData)

    @Before
    fun before(){
        composeTestRule.setContent {
            DotaInfoTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.HeroList.route,
                    builder = {
                        addHeroList(
                            navController = navController,
                            imageLoader = imageLoader
                        )
                        addHeroDetail(
                            imageLoader = imageLoader
                        )
                    }
                )
            }
        }
    }

    @Test
    fun getHeros(){
        composeTestRule.onNodeWithText("Anti-Mage").assertIsDisplayed()
    }
}




















