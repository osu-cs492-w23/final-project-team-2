package com.example.eivom.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson
import java.io.Serializable

@JsonClass(generateAdapter = true)
@Entity
data class MovieList(
    @PrimaryKey
    val title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String
): Serializable


@JsonClass(generateAdapter = true)
data class MovieListJson(
    val title: String,
    val overview: String,
    val poster_path: String?,
    val release_date: String
)

class EivomListJsonAdapter{
    @FromJson
    fun movieInfoFromJson(list: MovieListJson) = MovieList(
        title = list.title,
        overview = list.overview,
        poster_path = "https://image.tmdb.org/t/p/w500${list.poster_path}",
        release_date = list.release_date
    )

    @ToJson
    fun movieListToJson(movieList: MovieList): String{
        throw UnsupportedOperationException("Encoding MovieList to Json is not supported")
    }
}


