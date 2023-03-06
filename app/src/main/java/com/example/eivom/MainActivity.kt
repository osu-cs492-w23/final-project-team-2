package com.example.eivom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieListRV: RecyclerView = findViewById(R.id.rv_movie_info_list)
        movieListRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        movieListRV.setHasFixedSize(true)

        val adapter = MovieInfoAdapter()
        movieListRV.adapter = adapter

        adapter.addMovieInfo(
            MovieInfo(
                "Movie Image 4"
            )
        )

        adapter.addMovieInfo(
            MovieInfo(
                "Movie Image 3"
            )
        )

        adapter.addMovieInfo(
            MovieInfo(
                "Movie Image 2"
            )
        )

        adapter.addMovieInfo(
            MovieInfo(
                "Movie Image 1"
            )
        )


    }
}