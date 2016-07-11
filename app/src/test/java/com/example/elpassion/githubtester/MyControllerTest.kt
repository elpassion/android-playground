package com.example.elpassion.githubtester

import com.nhaarman.mockito_kotlin.*
import org.junit.Before
import org.junit.Test
import rx.Observable


class MyControllerTest {
    val api = mock<GithubApi>()
    val view = mock<MyView>()
    val controller = MyController(view, api)

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
    fun testShouldShowQueryResults() {
        controller.onQueryChanged("asdasd")

        verify(view).showResults(any<Users>())
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

interface GithubApi {
    fun call(query: String): Observable<Users>
}

interface MyView {
    fun showEmptyListPlaceholder()

    fun showResults(users: Users)

    fun showError(throwable: Throwable)
}

data class Users(val user: List<User>)

data class User(val id: String)


class MyController(val view: MyView, val api: GithubApi) {
    fun onCreate() {
        view.showEmptyListPlaceholder()
    }

    fun onQueryChanged(query: String) {
        api.call(query).subscribe({
            view.showResults(Users(emptyList()))
        }, {
            view.showError(it)
        })
    }
}
