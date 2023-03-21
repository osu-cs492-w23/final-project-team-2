package com.example.eivom.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eivom.api.EivomService
import com.example.eivom.data.MovieInfo
import com.example.eivom.data.MovieInfoRepository

class MovieInfoViewModel: ViewModel()  {
    private val repository = MovieInfoRepository(EivomService.create())

    private val _info = MutableLiveData<MovieInfo?>(null)

    val info: LiveData<MovieInfo?> = _info

    

}