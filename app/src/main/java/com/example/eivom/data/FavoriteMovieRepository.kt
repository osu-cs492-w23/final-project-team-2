package com.example.eivom.data

class FavoriteMovieRepository(
    private val dao: MovieDao
) {
    suspend fun insertFavoriteMovie(movie: FavoriteMovies) = dao.insert(movie)

    suspend fun deleteFavoriteMovie(movie: FavoriteMovies) = dao.delete(movie)

    fun getAllFavoriteMovies() = dao.getAllMovies()
}