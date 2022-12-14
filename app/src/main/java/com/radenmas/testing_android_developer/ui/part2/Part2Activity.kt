package com.radenmas.testing_android_developer.ui.part2

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.radenmas.testing_android_developer.databinding.ActivityPart2Binding

class Part2Activity : AppCompatActivity() {

    private lateinit var bind: ActivityPart2Binding
    private lateinit var part2ViewModel: Part2ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityPart2Binding.inflate(layoutInflater)
        setContentView(bind.root)

        part2ViewModel = Part2ViewModel(
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
                part2ViewModel.searchJokes(etSearch)
            }
            false
        }
    }

    private fun initView() {
        part2ViewModel.initAdapter()
        part2ViewModel.searchJokes("dev")
    }
}