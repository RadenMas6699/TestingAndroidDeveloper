package com.radenmas.testing_android_developer

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.radenmas.testing_android_developer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        mainViewModel = MainViewModel(
            bind.rvJokes,
            bind.progress,
            bind.tvEmpty,
            this,
            this
        )

        initView()
        onClick()
    }

    private fun onClick() {
        bind.etSearch.setOnEditorActionListener { _, action, _ ->
            if (action == EditorInfo.IME_ACTION_SEARCH) {
                val etSearch = bind.etSearch.text.toString().trim()
                mainViewModel.searchJokes(etSearch)
            }
            false
        }
    }

    private fun initView() {
        mainViewModel.initAdapter()
        mainViewModel.searchJokes("dev")
    }
}