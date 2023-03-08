package com.example.eivom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ActionmovieListRV: RecyclerView = findViewById(R.id.rv_action_movie_info_list)
        ActionmovieListRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        ActionmovieListRV.setHasFixedSize(true)

        val ActionAdapter = ActionMovieInfoAdapter()
        ActionmovieListRV.adapter = ActionAdapter

        ActionAdapter.addMovieInfo(
            MovieInfo(
                "Movie Image 4"
            )
        )

        ActionAdapter.addMovieInfo(
            MovieInfo(
                "Movie Image 3"
            )
        )

        ActionAdapter.addMovieInfo(
            MovieInfo(
                "Movie Image 2"
            )
        )

        ActionAdapter.addMovieInfo(
            MovieInfo(
                "Movie Image 1"
            )
        )

        val ComedyMovieListRV: RecyclerView = findViewById(R.id.rv_comedy_movie_info_list)
        ComedyMovieListRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        ComedyMovieListRV.setHasFixedSize(true)

        val ComedyAdapter = ComedyMovieInfoAdapter()
        ComedyMovieListRV.adapter = ComedyAdapter

        ComedyAdapter.addMovieInfo(
            MovieInfo(
                "Movie Image 4"
            )
        )

        ComedyAdapter.addMovieInfo(
            MovieInfo(
                "Movie Image 3"
            )
        )

        ComedyAdapter.addMovieInfo(
            MovieInfo(
                "Movie Image 2"
            )
        )

        ComedyAdapter.addMovieInfo(
            MovieInfo(
                "Movie Image 1"
            )
        )


    }
}