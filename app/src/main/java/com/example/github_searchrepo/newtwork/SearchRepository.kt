package com.example.github_searchrepo.newtwork

import com.example.github_searchrepo.model.RepositoriesModel
import io.reactivex.Observable

interface SearchRepository {
    fun getData(searchString: String): Observable<RepositoriesModel>
}