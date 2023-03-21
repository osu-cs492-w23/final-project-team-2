package com.example.eivom.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieList(
    val title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val genre: List<Int>
)


