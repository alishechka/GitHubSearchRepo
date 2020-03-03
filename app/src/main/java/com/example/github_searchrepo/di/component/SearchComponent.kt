package com.example.github_searchrepo.di.component

import com.example.github_searchrepo.MainActivity
import com.example.github_searchrepo.di.module.SearchModule
import com.example.github_searchrepo.di.scope.ActivityScope
import dagger.Component

@Component(modules = [SearchModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface SearchComponent {

    fun inject(mainActivity: MainActivity)


}