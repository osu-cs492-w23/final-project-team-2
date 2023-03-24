package com.example.eivom.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson

data class PersonList(
    val adult: Boolean,
    val name: String,
    val popularity: String,
    val gender: Int,
    val known_for_department: String,
    val profile_path: String,
): java.io.Serializable

@JsonClass(generateAdapter = true)
data class PersonListJson(
    val adult: Boolean,
    val name: String,
    val popularity: Double,
    val gender: Int,
    val known_for_department: String,
    val profile_path: String,
    val known_for: List<MovieJson>?
)

@JsonClass(generateAdapter = true)
data class MovieJson(
    val poster_path: String
)

class PersonListJsonAdapter{
    @FromJson
    fun personInfoFromJson(list: PersonListJson) = PersonList(
        adult = list.adult,
        name = list.name,
        popularity = "Popularity: ${list.popularity.toBigDecimal().toPlainString()} %",
        gender = list.gender,
        known_for_department = list.known_for_department,
        profile_path = "https://image.tmdb.org/t/p/w500${list.profile_path}"
    )

    @ToJson
    fun personListToJson(personList: PersonList): String{
        throw UnsupportedOperationException("Encoding PersonList to Json is not supported")
    }
}

