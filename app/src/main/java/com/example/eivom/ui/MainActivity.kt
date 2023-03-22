package com.example.eivom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.eivom.R
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp


const val MOVIEDATABASE_APPID = "9b548beeca2515183884381852406153"

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfig : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment
        )as NavHostFragment

        val navController = navHostFragment.navController

        appBarConfig = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfig)
    }

    override fun onSupportNavigateUp(): Boolean{
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }
}