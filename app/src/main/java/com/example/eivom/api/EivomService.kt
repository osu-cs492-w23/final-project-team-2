package com.example.eivom.api

import com.example.eivom.data.EivomListJsonAdapter
import com.example.eivom.data.MovieInfo
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This is a Retrofit service interface encapsulating communication with the OpenWeather API.
 */
interface EivomService {
    @GET("/trending/movie/week")
    suspend fun loadMovieList(
        @Query("api_key") apiKey: String
    ) : Response<MovieInfo>

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        /**
         * This method can be called as `OpenWeatherService.create()` to create an object
         * implementing the OpenWeatherService interface and which can be used to make calls to
         * the OpenWeather API.
         */
        fun create() : EivomService {
            val moshi = Moshi.Builder()
                .add(EivomListJsonAdapter())
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(EivomService::class.java)
        }
    }
}