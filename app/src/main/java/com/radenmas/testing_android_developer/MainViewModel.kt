package com.radenmas.testing_android_developer

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.radenmas.testing_android_developer.adapter.JokesAdapter
import com.radenmas.testing_android_developer.model.ResponseJokes
import com.radenmas.testing_android_developer.model.ResultItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by RadenMas on 13/12/2022.
 */
@SuppressLint("StaticFieldLeak")
class MainViewModel(
    private val recyclerView: RecyclerView,
    private val progress: ProgressBar,
    private val empty: TextView,
    private val context: Context,
    private val activity: Activity
) : ViewModel() {

    lateinit var adapter: JokesAdapter
    lateinit var items: List<ResultItem>

    fun initAdapter() {
        adapter = JokesAdapter(context)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    fun searchJokes(query: String) {
        progress.visibility = View.VISIBLE

        val imm: InputMethodManager =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocus = activity.currentFocus
        if (currentFocus != null) imm.hideSoftInputFromWindow(
            currentFocus.applicationWindowToken, 0
        )

        RetrofitClient.instance.jokes(query).enqueue(object : Callback<ResponseJokes> {
            override fun onResponse(call: Call<ResponseJokes>, response: Response<ResponseJokes>) {
                progress.visibility = View.GONE
                if (response.body()?.total == 0) {
                    empty.visibility = View.VISIBLE
                } else {
                    empty.visibility = View.GONE
                    items = response.body()?.result!!
                    for (c in items) {
                        Log.d("TAG", items.toString())
                        adapter.setJokes(items)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseJokes>, t: Throwable) {
                progress.visibility = View.GONE
            }
        })
    }
}