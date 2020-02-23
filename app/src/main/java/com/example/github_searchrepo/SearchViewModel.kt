package com.example.github_searchrepo

import RepositoriesModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github_searchrepo.newtwork.SearchRepository
import io.reactivex.disposables.CompositeDisposable

class SearchViewModel(val repo: SearchRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val searchLiveDataSuccess = MutableLiveData<RepositoriesModel>()
    val searchLiveDataError = MutableLiveData<String>()

    fun getSearchRepository(s: String) {
        compositeDisposable.add(
            repo.getData(s).subscribe({ i -> searchLiveDataSuccess.value = i },
                { e -> searchLiveDataError.value = e.message })

        )
    }

}