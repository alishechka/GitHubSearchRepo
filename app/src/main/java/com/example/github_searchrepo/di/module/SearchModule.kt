package com.example.github_searchrepo.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.github_searchrepo.MainActivity
import com.example.github_searchrepo.SearchViewModel
import com.example.github_searchrepo.SearchViewModelFactory
import com.example.github_searchrepo.di.scope.ActivityScope
import com.example.github_searchrepo.newtwork.SearchClient
import com.example.github_searchrepo.newtwork.SearchRepositoriesImpl
import com.example.github_searchrepo.newtwork.SearchRepository
import dagger.Module
import dagger.Provides

@Module
class SearchModule(private val activity: MainActivity) {
    @Provides
    @ActivityScope
    fun provideViewModelFactory(searchRepository: SearchRepository): SearchViewModelFactory {
        return SearchViewModelFactory(searchRepository)
    }

    @Provides
    @ActivityScope
    fun provideRepository(client: SearchClient): SearchRepository {
        return SearchRepositoriesImpl(client)
    }

    @Provides
    @ActivityScope
    fun getViewModel(searchViewModelFactory: SearchViewModelFactory ): SearchViewModel {
        return ViewModelProvider(activity, searchViewModelFactory).get(SearchViewModel::class.java)
    }

}