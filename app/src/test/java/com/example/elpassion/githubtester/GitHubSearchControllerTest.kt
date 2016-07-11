package com.example.elpassion.githubtester

import com.example.elpassion.githubtester.search.*
import com.nhaarman.mockito_kotlin.*
import org.junit.Before
import org.junit.Test
import rx.Observable


class GitHubSearchControllerTest {
    val api = mock<GitHubApi>()
    val view = mock<GitHubResultsView>()
    val controller = GitHubSearchController(view, api)

    @Before
    fun setUp() {
        whenever(api.call(any())).thenReturn(Observable.just(Users(emptyList())))
    }

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

    @Test
    fun testShouldShowQueryResultsWhenNotEmpty() {
        val results = Users(users = listOf(User("1")))
        whenever(api.call(any())).thenReturn(Observable.just(results))
        controller.onQueryChanged("asdasd")

        verify(view).showResults(results)
    }

    @Test
    fun testShouldShowEmptyResultsPlaceholderWhenResultsAreEmpty() {
        controller.onQueryChanged("asdasd")

        verify(view).showEmptyListPlaceholder()
    }

    @Test
    fun testShouldShowErrorWhenApiCallFails() {
        whenever(api.call(any())).thenReturn(Observable.error(RuntimeException()))
        controller.onQueryChanged("asd")

        verify(view).showError(any<Throwable>())
    }

    @Test
    fun testShouldNotShowResultsIfErrorOccurs() {
        whenever(api.call(any())).thenReturn(Observable.error(RuntimeException()))
        controller.onQueryChanged("asd")

        verify(view, never()).showResults(any())
    }
}
