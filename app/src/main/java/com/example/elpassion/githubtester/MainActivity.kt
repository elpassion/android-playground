package com.example.elpassion.githubtester

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.elpassion.githubtester.search.GitHubApi
import com.example.elpassion.githubtester.search.GitHubResultsView
import com.example.elpassion.githubtester.search.GitHubSearchController
import com.example.elpassion.githubtester.search.Users

class MainActivity : AppCompatActivity(), GitHubResultsView {

    val controller by lazy { GitHubSearchController(this, gitHubApiProvider()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller.onCreate()
    }

    override fun showEmptyListPlaceholder() {
        findViewById(R.id.empty_placeholder).visibility = View.VISIBLE
    }

    override fun showResults(users: Users) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(throwable: Throwable) {
        findViewById(R.id.api_error).visibility = View.VISIBLE
    }

    companion object {
        lateinit var gitHubApiProvider: () -> GitHubApi
    }
}
