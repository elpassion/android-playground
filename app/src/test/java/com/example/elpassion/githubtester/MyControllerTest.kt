package com.example.elpassion.githubtester

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test


class MyControllerTest {
    val api = mock<GithubApi>()
    val view = mock<MyView>()
    val controller = MyController(view, api)

    @Test
    fun testShouldShowEmptyListPlaceholderOnCreate() {
        controller.onCreate()
        verify(view).showEmptyListPlaceholder()
    }

    @Test
    fun testShouldCallGithubApiAfterQueryChanged() {
        val query = "asdasd"
        controller.onQueryChanged(query)

        verify(api).call(query)
    }
}

interface GithubApi {
    fun call(query: String)
}

interface MyView {
    fun showEmptyListPlaceholder()
}

class MyController(val view: MyView, val api: GithubApi) {
    fun onCreate() {
        view.showEmptyListPlaceholder()
    }

    fun onQueryChanged(query: String) {
        api.call(query)
    }
}
