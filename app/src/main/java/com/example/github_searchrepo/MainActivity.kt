package com.example.github_searchrepo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github_searchrepo.adapter.SearchAdapter
import com.example.github_searchrepo.newtwork.SearchRepositoriesImpl
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import com.example.github_searchrepo.di.component.DaggerAppComponent
import com.example.github_searchrepo.di.component.DaggerSearchComponent
import com.example.github_searchrepo.di.module.SearchModule
import dagger.internal.DaggerCollections
import javax.inject.Inject

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var searchViewModelFactory: SearchViewModelFactory

    @Inject
    lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSearchComponent
            .builder()
            .appComponent((application as MyApp).component())
            .searchModule(SearchModule(this))
            .build().inject(this)

//        val viewModel = ViewModelProvider(this, searchViewModelFactory)
//            .get(SearchViewModel::class.java)


        viewModel.searchLiveDataSuccess.observe(this@MainActivity, Observer {
            tv_show_count.text = it.total_count.toString()
            rv_display_search.adapter = SearchAdapter(it)
            rv_display_search.layoutManager = LinearLayoutManager(this@MainActivity)

        })

        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.getSearchRepository(s.toString())
            }
        })

    }
}
