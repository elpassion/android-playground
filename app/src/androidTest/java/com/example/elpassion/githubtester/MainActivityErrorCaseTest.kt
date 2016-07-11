package com.example.elpassion.githubtester

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import com.example.elpassion.githubtester.search.GitHubApi
import com.example.elpassion.githubtester.search.Users
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Rule
import org.junit.Test
import rx.Observable

class MainActivityErrorCaseTest {

    @JvmField
    @Rule
    val rule = object : ActivityTestRule<MainActivity>(MainActivity::class.java) {
        override fun beforeActivityLaunched() {
            super.beforeActivityLaunched()
            MainActivity.gitHubApiProvider = {
                object : GitHubApi {
                    override fun call(query: String): Observable<Users> = Observable.error(RuntimeException())
                }
            }
        }
    }

    @Test
    fun shouldShowErrorView() {
        onView(withId(R.id.api_error)).check(matches(isDisplayed()))
    }
}

