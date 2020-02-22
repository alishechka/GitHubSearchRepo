package com.example.github_searchrepo.newtwork

import RepositoriesModel
import io.reactivex.Observable

interface SearchRepository {
    fun getData(searchString: String): Observable<RepositoriesModel>
}