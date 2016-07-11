package com.example.elpassion.githubtester

class MyController(val view: MyView, val api: GithubApi) {
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
