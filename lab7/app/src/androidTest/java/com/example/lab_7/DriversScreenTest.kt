package com.example.lab_7

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertRangeInfoEquals
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertValueEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DriversScreenTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()      //access MainActivity


    @Test
    fun testDriverScreen(){
        composeTestRule                         //verify button exists then click it
            .onNodeWithTag("racerButton")
            .assertExists()
            .performClick()

        composeTestRule                         //ensure you're on the driver's screen
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()
    }

    @Test
    fun testAddDriver(){
        composeTestRule                         //go to driver screen first
            .onNodeWithTag("racerButton")
            .assertExists()
            .performClick()

        composeTestRule                         //input a test racer
            .onNodeWithTag("nameInput")
            .performTextInput("John Test")

        composeTestRule                         //verify add button exists then click it
            .onNodeWithTag("addDriverButton")
            .assertExists()
            .performClick()

        composeTestRule                         //test if driver is properly displayed
            .onNodeWithText("John Test")
            //.assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testClearDriver(){
        composeTestRule                         //go to driver screen first
            .onNodeWithTag("racerButton")
            .performClick()

        composeTestRule                         //make sure nothing is in the list first
            .onNodeWithText("John Test")
            .assertIsNotDisplayed()

        composeTestRule                         //input a test racer
            .onNodeWithTag("nameInput")
            .performTextInput("John Test")

        composeTestRule                         //add test racer to the list
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule                         //ensure racer is displayed in list
            .onNodeWithText("John Test")
            .assertIsDisplayed()

        composeTestRule                         //verify clear button works
            .onNodeWithTag("clearButton")
            .performClick()

        composeTestRule                         //test if its empty
            .onNodeWithText("John Test")
            .assertIsNotDisplayed()
    }

    @Test
    fun testBackButton(){
        composeTestRule                         //go to driver screen first
            .onNodeWithTag("racerButton")
            .performClick()

        composeTestRule                         //verify back button exists then use it
            .onNodeWithTag("backButton")
            .assertExists()
            .performClick()

        composeTestRule                         //verify it goes back to home screen
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
