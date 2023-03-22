package com.example.eivom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eivom.BuildConfig
import com.example.eivom.R
import com.example.eivom.data.MovieInfo

const val MOVIEDATABASE_APPID = "9b548beeca2515183884381852406153"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ActionmovieListRV: RecyclerView = findViewById(R.id.rv_action_movie_info_list)
        ActionmovieListRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        ActionmovieListRV.setHasFixedSize(true)

        val ActionAdapter = ActionMovieInfoAdapter()
        ActionmovieListRV.adapter = ActionAdapter

        val ComedyMovieListRV: RecyclerView = findViewById(R.id.rv_comedy_movie_info_list)
        ComedyMovieListRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        ComedyMovieListRV.setHasFixedSize(true)

        val ComedyAdapter = ComedyMovieInfoAdapter()
        ComedyMovieListRV.adapter = ComedyAdapter
    }
}