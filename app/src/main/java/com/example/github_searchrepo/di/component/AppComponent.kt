package com.example.github_searchrepo.di.component

import com.example.github_searchrepo.MyApp
import com.example.github_searchrepo.di.module.NetworkModule
import com.example.github_searchrepo.newtwork.SearchClient
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {

    fun inject(myApp: MyApp)

    fun client():SearchClient



}