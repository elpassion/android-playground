package com.example.elpassion.githubtester

interface MyView {
    fun showEmptyListPlaceholder()

    fun showResults(users: Users)

    fun showError(throwable: Throwable)
}
