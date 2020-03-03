package com.example.github_searchrepo.di.module

import com.example.github_searchrepo.newtwork.SearchClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

    }

    @Provides
    @Singleton
    fun provideClient(retrofit: Retrofit): SearchClient {
        return retrofit.create(SearchClient::class.java)

    }

}