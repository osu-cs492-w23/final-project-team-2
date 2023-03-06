package com.example.eivom

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class MovieInfoAdapter: Adapter<MovieInfoAdapter.MovieInfoViewHolder>(){
    val movieInfoList: MutableList<MovieInfo> = mutableListOf()

    override fun getItemCount() = movieInfoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieInfoViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_info_list_item, parent, false)

        return MovieInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieInfoViewHolder, position: Int) {
        holder.bind(movieInfoList[position])
    }

    fun addMovieInfo(movieInfo: MovieInfo){
        movieInfoList.add(0, movieInfo)
        notifyItemInserted(0)
    }

    class MovieInfoViewHolder(view: View): ViewHolder(view){
        private val movie_image: TextView = view.findViewById(R.id.movie_image)

        private var currentMovieInfo: MovieInfo? = null

        fun bind(movieInfo: MovieInfo){
            currentMovieInfo = movieInfo
            movie_image.text = movieInfo.movie_image
        }
    }
}