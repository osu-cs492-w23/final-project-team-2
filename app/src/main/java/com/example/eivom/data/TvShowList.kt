package com.example.eivom.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson

data class TvShowList(
    val adult : Boolean,
    val name : String,
    val original_language : String,
    val overview : String,
    val poster_path: String?
): java.io.Serializable

@JsonClass(generateAdapter = true)
data class TvShowListJson(
    val adult : Boolean,
    val name : String,
    val original_language : String,
    val overview : String,
    val poster_path: String?
)

class TvShowListJsonAdapter{
    @FromJson
    fun tvShowInfoFromJson(list: TvShowListJson) = TvShowList(
        adult = list.adult,
        name = list.name,
        original_language = list.original_language,
        overview = list.overview,
        poster_path = "https://image.tmdb.org/t/p/w500${list.poster_path}"
    )

    @ToJson
    fun tvShowListToJson(list: TvShowList): String{
        throw java.lang.UnsupportedOperationException("Encoding TvShowList to Json is not supported")
    }
}