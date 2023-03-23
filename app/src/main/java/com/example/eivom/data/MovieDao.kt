package com.example.eivom.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: FavoriteMovies)

    @Delete
    suspend fun delete(movie: FavoriteMovies)

    @Query("SELECT * FROM FavoriteMovies ORDER BY timestamp DESC")
    fun getAllMovies(): Flow<List<FavoriteMovies>>
}