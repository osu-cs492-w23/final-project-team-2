package com.example.eivom.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.eivom.R
import com.example.eivom.data.MovieInfo
import com.example.eivom.data.MovieList

class MovieInfoAdapter(private val onClick: (MovieList) -> Unit): RecyclerView.Adapter<MovieInfoAdapter.MovieInfoViewHolder>(){
    var movieInfoList: List<MovieList> = listOf()

    fun updateInfo(info: MovieInfo?) {
        movieInfoList = info?.result ?: listOf()
        Log.d("MovieInforAdapter", "Data: $movieInfoList")
        notifyDataSetChanged()
    }

    override fun getItemCount() = movieInfoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_info_list_item, parent, false)

        return MovieInfoViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: MovieInfoViewHolder, position: Int) {
        holder.bind(movieInfoList[position])
    }

    class MovieInfoViewHolder(view: View, val onClick: (MovieList) -> Unit): RecyclerView.ViewHolder(view){

        private var currentMovieInfo: MovieList? = null

        fun bind(movieInfo: MovieList){
            currentMovieInfo = movieInfo
        }
    }
}