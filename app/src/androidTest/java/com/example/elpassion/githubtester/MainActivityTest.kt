package com.example.elpassion.githubtester

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @JvmField
    @Rule
    val rule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testShouldStartMainActivity() {

    }

    @Test
    fun testEmptyPlaceholderShouldBeVisibleOnCreate() {
        onView(withId(R.id.empty_placeholder)).check(matches(isDisplayed()))
    }
}