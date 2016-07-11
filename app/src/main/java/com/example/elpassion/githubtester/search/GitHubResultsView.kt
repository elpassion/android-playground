package com.example.elpassion.githubtester.search

interface GitHubResultsView {
    fun showEmptyListPlaceholder()

    fun showResults(users: Users)

    fun showError(throwable: Throwable)
}
