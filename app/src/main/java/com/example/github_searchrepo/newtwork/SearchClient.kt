package com.example.github_searchrepo.newtwork

import com.example.github_searchrepo.model.RepositoriesModel
import com.example.github_searchrepo.misc.END_POINT_SEARCH_REPO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchClient {
    @GET(END_POINT_SEARCH_REPO)
    fun getSearchRepo(@Query("q") search: String): Observable<RepositoriesModel>
}