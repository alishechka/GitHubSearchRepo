package com.example.github_searchrepo.newtwork

import com.example.github_searchrepo.model.RepositoriesModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchRepositoriesImpl @Inject constructor(private val repoClient: SearchClient) :
    SearchRepository {
//    private val client = SearchRetrofitClient.getRetrofitInstance

    override fun getData(searchString: String): Observable<RepositoriesModel> {
        return repoClient.getSearchRepo(searchString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}