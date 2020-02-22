package com.example.github_searchrepo

import RepositoriesModel
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github_searchrepo.adapter.SearchAdapter
import com.example.github_searchrepo.newtwork.SearchRepositoriesImpl
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this, SearchViewModelFactory(SearchRepositoriesImpl()))
            .get(SearchViewModel::class.java)


        viewModel.searchLiveDataSuccess.observe(this@MainActivity, Observer {
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
