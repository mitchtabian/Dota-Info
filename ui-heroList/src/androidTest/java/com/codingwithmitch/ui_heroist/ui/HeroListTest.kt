package com.codingwithmitch.ui_heroist.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Text
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class HeroListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            Text("Hey look some text")
        }
    }

    @Test
    fun zeusIsShown() {
        composeTestRule.onNodeWithText("Hey look some text").assertIsDisplayed()
    }

}













