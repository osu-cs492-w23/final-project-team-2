package com.example.eivom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.eivom.R
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import com.example.eivom.data.MovieList


const val MOVIEDATABASE_APPID = "9b548beeca2515183884381852406153"

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val movieInfoAdapter = MovieInfoAdapter(::onMoviePosterClick)

    private lateinit var appBarConfig : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_info_test)

//        val navHostFragment = supportFragmentManager.findFragmentById(
//            R.id.nav_host_fragment
//        )as NavHostFragment

//        val navController = navHostFragment.navController

//        appBarConfig = AppBarConfiguration(navController.graph)
//
//        setupActionBarWithNavController(navController, appBarConfig)
    }

    private fun onMoviePosterClick(detail: MovieList) {
        Log.d(TAG, "Movie poster clicked")
    }

    override fun onSupportNavigateUp(): Boolean{
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }
}