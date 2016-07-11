package com.example.elpassion.githubtester.search

import rx.Observable

interface GitHubApi {
    fun call(query: String): Observable<Users>
}