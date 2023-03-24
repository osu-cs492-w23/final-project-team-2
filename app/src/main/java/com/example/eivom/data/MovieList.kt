package com.example.eivom.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson
import java.io.Serializable

data class MovieList(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val genre_ids: List<Int>
): Serializable

@JsonClass(generateAdapter = true)
data class MovieListJson(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,
    val release_date: String,
    val genre_ids: List<Int>
)

class EivomListJsonAdapter{
    @FromJson
    fun movieInfoFromJson(list: MovieListJson) = MovieList(
        id = list.id,
        title = list.title,
        overview = list.overview,
        poster_path = "https://image.tmdb.org/t/p/w500${list.poster_path}",
        release_date = list.release_date,
        genre_ids = list.genre_ids
    )

    @ToJson
    fun movieListToJson(movieList: MovieList): String{
        throw UnsupportedOperationException("Encoding MovieList to Json is not supported")
    }
}


