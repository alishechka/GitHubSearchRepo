package com.example.github_searchrepo

import Items
import RepositoriesModel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.github_searchrepo.newtwork.SearchRepository
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: SearchRepository
    @Mock
    private lateinit var observer: Observer<RepositoriesModel>

    private lateinit var viewModel: SearchViewModel

    @Before
    fun setUp() {
        viewModel = SearchViewModel(repository)
        viewModel.searchLiveDataSuccess.observeForever(observer)


    }

    @Test
    fun `get data call returns success`() {
        val item1: Items = Items("Ali")
        val item2: Items = Items("Idelson")
        val item3: Items = Items("Arty")
        val itemList = listOf<Items>(item1, item2, item3)
        val testModel = RepositoriesModel(10, false, itemList)

        //given
        Mockito.`when`(repository.getData("test")).thenReturn(Observable.just(testModel))

        //when
        viewModel.getSearchRepository("test")

        //then
        Mockito.verify(observer).onChanged(testModel)
    }

}