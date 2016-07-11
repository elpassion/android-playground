package com.example.elpassion.githubtester.search

import com.example.elpassion.githubtester.search.GitHubApi
import com.example.elpassion.githubtester.search.GitHubResultsView

class GitHubSearchController(val view: GitHubResultsView, val api: GitHubApi) {
    fun onCreate() {
        view.showEmptyListPlaceholder()
    }

    fun onQueryChanged(query: String) {
        api.call(query).subscribe({
            if (it.users.isNotEmpty()) {
                view.showResults(it)
            } else {
                view.showEmptyListPlaceholder()
            }
        }, {
            view.showError(it)
        })
    }
}
