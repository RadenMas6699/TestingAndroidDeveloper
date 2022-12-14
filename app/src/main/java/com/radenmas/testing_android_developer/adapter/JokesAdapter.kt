package com.radenmas.testing_android_developer.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.radenmas.testing_android_developer.R
import com.radenmas.testing_android_developer.databinding.ListJokesBinding
import com.radenmas.testing_android_developer.model.ResultItem

/**
 * Created by RadenMas on 13/12/2022.
 */
class JokesAdapter(val context: Context) :
    RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {

    private val jokes: MutableList<ResultItem> = mutableListOf()

    inner class JokesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var bind: ListJokesBinding = ListJokesBinding.bind(view)

        fun bindJokes(response: ResultItem) {
            response.let {
                val iconUrl = it.iconUrl.replace(
                    "https://assets.chucknorris.host/",
                    "https://api.chucknorris.io/"
                )

                Glide.with(context)
                    .load(iconUrl)
                    .placeholder(R.drawable.ic_picture)
                    .into(bind.imgIcon)
                bind.tvId.text = it.id
                bind.tvJokes.text = it.value
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setJokes(data: List<ResultItem>) {
        jokes.clear()
        jokes.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        return JokesViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_jokes, parent, false)
        )
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.bindJokes(jokes[position])
    }

    override fun getItemCount(): Int {
        return jokes.size
    }
}