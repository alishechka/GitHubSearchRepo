package com.example.github_searchrepo.newtwork

import RepositoriesModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchRepositoriesImpl : SearchRepository {
    private val client = SearchRetrofitClient.getRetrofitInstance

    override fun getData(searchString: String): Observable<RepositoriesModel> {
        return client.getSearchRepo(searchString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}