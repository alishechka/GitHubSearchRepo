package com.example.github_searchrepo

import android.app.Application
import com.example.github_searchrepo.di.component.AppComponent
import com.example.github_searchrepo.di.component.DaggerAppComponent
import com.example.github_searchrepo.di.module.NetworkModule

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        component()
    }

    fun component(): AppComponent {
        return DaggerAppComponent.builder()
            .networkModule(NetworkModule()).build()
    }
}