package com.example.eivom.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.eivom.data.AppDatabase
import com.example.eivom.data.FavoriteMovieRepository
import com.example.eivom.data.FavoriteMovies
import kotlinx.coroutines.launch

class FavoriteMoviesViewModel(application: Application): AndroidViewModel(application) {
    private val repository = FavoriteMovieRepository(
        AppDatabase.getInstance(application).movieDao()
    )

    val favoriteMovies = repository.getAllFavoriteMovies().asLiveData()

    fun addFavoriteMovie(movie: FavoriteMovies) {
        viewModelScope.launch {
            repository.insertFavoriteMovie(movie)
        }
    }

    fun removeFavoriteMovie(movie: FavoriteMovies) {
        viewModelScope.launch {
            repository.deleteFavoriteMovie(movie)
        }
    }
}