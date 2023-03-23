package com.example.eivom.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieInfo(
    @Json(name = "results") val result: List<MovieList>
)
