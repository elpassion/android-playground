package com.example.elpassion.githubtester

import rx.Observable

interface GithubApi {
    fun call(query: String): Observable<Users>
}