package com.example.eivom.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.eivom.R
import com.example.eivom.data.MovieInfo
import com.example.eivom.data.MovieList

class MovieInfoAdapter(private val onClick: (MovieList) -> Unit): RecyclerView.Adapter<MovieInfoAdapter.MovieInfoViewHolder>(){
    var movieInfoList: List<MovieList> = listOf()

    fun updateInfo(info: MovieInfo?) {
        movieInfoList = info?.result ?: listOf()
        Log.d("MovieInfoAdapter", "Data: $movieInfoList")
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

        private val posterTV: ImageView = itemView.findViewById(R.id.movie_poster)
        private val overview: TextView = itemView.findViewById(R.id.overview)

        private var currentMovieInfo: MovieList? = null

        fun bind(movieList: MovieList){
            val ctx = itemView.context

            currentMovieInfo = movieList
//            overview.text = movieList.overview


            Glide.with(ctx)
                .load(movieList.poster_path)
                .into(posterTV)

        }
    }
}