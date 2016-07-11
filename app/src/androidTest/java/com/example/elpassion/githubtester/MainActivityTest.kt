package com.example.elpassion.githubtester

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
}