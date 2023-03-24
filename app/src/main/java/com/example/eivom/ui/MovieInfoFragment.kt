package com.example.eivom.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eivom.R
import com.example.eivom.data.*

import com.google.android.material.progressindicator.CircularProgressIndicator

class MovieInfoFragment : Fragment(R.layout.movie_info) {
    private val TAG = "MovieInfoFragment"

    //Movies
    private val movieInfoViewModel : MovieInfoViewModel by viewModels()
    private val infoAdapter = MovieInfoAdapter(::onInfoItemClick)

    //TvShows
    private val tvShowInfoViewModel : TvShowViewModel by viewModels()
    private val tvShowInfoAdapter = TvShowInfoAdapter(::onTvShowItemClick)

    //Person
    private val personInfoViewModel : PersonInfoViewModel by viewModels()
    private val personInfoAdapter = PersonInfoAdapter(::onPersonItemClick)

    private lateinit var movieInfoRV : RecyclerView
    private lateinit var tvShowInfoRV : RecyclerView
    private lateinit var personInfoRV : RecyclerView

    private lateinit var loadingErrorTV : TextView
    private lateinit var loadingIndicator : CircularProgressIndicator

    override fun onViewCreated(
        view : View,
        savedInstancesState: Bundle?
    ){
        super.onViewCreated(view, savedInstancesState)

        loadingErrorTV = view.findViewById(R.id.tv_loading_error)
        loadingIndicator = view.findViewById(R.id.loading_indicator)

        movieInfoRV = view.findViewById(R.id.rv_movie_info)
        movieInfoRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        movieInfoRV.setHasFixedSize(true)
        movieInfoRV.adapter = infoAdapter

        tvShowInfoRV = view.findViewById(R.id.rv_movie_info2)
        tvShowInfoRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        tvShowInfoRV.setHasFixedSize(true)
        tvShowInfoRV.adapter = tvShowInfoAdapter

        personInfoRV = view.findViewById(R.id.rv_movie_info3)
        personInfoRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        personInfoRV.setHasFixedSize(true)
        personInfoRV.adapter = personInfoAdapter

        //MOVIEINFOVIEWMODEL
        movieInfoViewModel.info.observe(viewLifecycleOwner){info ->
            if(info != null){
                infoAdapter.updateInfo(info.result)
                movieInfoRV.visibility = View.VISIBLE
                movieInfoRV.scrollToPosition(0)
            }
        }

        movieInfoViewModel.error.observe(viewLifecycleOwner){error ->
            if(error != null){
                loadingErrorTV.text = getString(R.string.loading_error, error.message)
                loadingErrorTV.visibility = View.VISIBLE
                Log.e(TAG, "Error fetching MovieDatabase: ${error.message}")
            }
        }

        movieInfoViewModel.loading.observe(viewLifecycleOwner){loading ->
            if(loading){
                loadingIndicator.visibility = View.VISIBLE
                loadingErrorTV.visibility = View.INVISIBLE
                movieInfoRV.visibility = View.INVISIBLE
            }
            else{
                loadingIndicator.visibility = View.INVISIBLE
            }
        }

        //TVSHOWINFOVIEWMODEL
        tvShowInfoViewModel.info.observe(viewLifecycleOwner){info ->
            if(info != null){
                tvShowInfoAdapter.updateInfo(info)
                tvShowInfoRV.visibility = View.VISIBLE
                tvShowInfoRV.scrollToPosition(0)
            }
        }

        tvShowInfoViewModel.error.observe(viewLifecycleOwner){error ->
            if(error != null){
                loadingErrorTV.text = getString(R.string.loading_error_tvshow, error.message)
                loadingErrorTV.visibility = View.VISIBLE
                Log.e(TAG, "Error fetching TvShowDatabase: ${error.message}")
            }
        }

        tvShowInfoViewModel.loading.observe(viewLifecycleOwner){loading ->
            if(loading){
                loadingIndicator.visibility = View.VISIBLE
                loadingErrorTV.visibility = View.INVISIBLE
                tvShowInfoRV.visibility = View.INVISIBLE
            }
            else{
                loadingIndicator.visibility = View.INVISIBLE
            }
        }

        //PERSONINFOVIEWMODEL
        personInfoViewModel.info.observe(viewLifecycleOwner){info ->
            if(info != null){
                personInfoAdapter.updateInfo(info)
                personInfoRV.visibility = View.VISIBLE
                personInfoRV.scrollToPosition(0)
            }
        }

        personInfoViewModel.error.observe(viewLifecycleOwner){error ->
            if(error != null){
                loadingErrorTV.text = getString(R.string.loading_error_person, error.message)
                loadingErrorTV.visibility = View.VISIBLE
                Log.e(TAG, "Error fetching PersonDatabase: ${error.message}")
            }
        }

        personInfoViewModel.loading.observe(viewLifecycleOwner){loading ->
            if(loading){
                loadingIndicator.visibility = View.VISIBLE
                loadingErrorTV.visibility = View.INVISIBLE
                personInfoRV.visibility = View.INVISIBLE
            }
            else{
                loadingIndicator.visibility = View.INVISIBLE
            }
        }
    }
    override fun onResume() {
        super.onResume()

        movieInfoViewModel.loadMovieInfo("1f89bc62d244a63f91c60d7a7381ebd3")
        tvShowInfoViewModel.loadTvShowInfo("1f89bc62d244a63f91c60d7a7381ebd3")
        personInfoViewModel.loadPersonInfo("1f89bc62d244a63f91c60d7a7381ebd3")
    }

    private fun onInfoItemClick(list: MovieList) {
        val directions = MovieInfoFragmentDirections.navigateToMovieDetail(list)
        findNavController().navigate(directions)
    }

    private fun onTvShowItemClick(list: TvShowList){
    }

    private fun onPersonItemClick(list: PersonList){
    }
}