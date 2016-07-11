package com.example.elpassion.githubtester

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test


class MyControllerTest {
    val view = mock<MyView>()
    val controller = MyController(view)

    @Test
    fun testShouldShowEmptyListPlaceholderOnCreate() {
        controller.onCreate()
        verify(view).showEmptyListPlaceholder()
    }
}

interface MyView {
    fun showEmptyListPlaceholder()

}

class MyController(val view: MyView) {
    fun onCreate() {
        view.showEmptyListPlaceholder()
    }

}
