package com.example.eivom.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eivom.R
import com.example.eivom.data.MovieInfo
import com.example.eivom.data.MovieList
import com.google.android.material.progressindicator.CircularProgressIndicator

class MovieInfoFragment : Fragment() {
    private val TAG = "LANDINGPAGEFRAGMENT"

    private val movieInfoViewModel : MovieInfoViewModel by viewModels()
    private val infoAdapter = MovieInfoAdapter(::onInfoItemClick)
//    private val landingPageAdapter = LandingPageAdapter(::onLandingPageItemClick)

    private lateinit var landingPageRV : RecyclerView
    private lateinit var loadingErrorTV : TextView
    private lateinit var loadingIndicator : CircularProgressIndicator

    override fun onViewCreated(
        view : View,
        savedInstancesState: Bundle?
    ){
        super.onViewCreated(view, savedInstancesState)

//        loadingErrorTV = view.findViewById(R.id.tv_loading_error)
//        loadingIndicator = view.findViewById(R.id.loading_indicator)

//        landingPageRV = view.findViewById(R.id.rv_landingPage)
//        landingPageRV.layoutManager = LinearLayoutManager(requireContext())
//        landingPageRV.setHasFixedSize(true)
//        landingPageRV.adapter = landingPageAdapter

        //LandingPageViewModel.observe SECTION

        movieInfoViewModel.info.observe(viewLifecycleOwner) { info ->
            if (info != null) {
                infoAdapter.updateInfo(info)
//                forecastListRV.visibility = View.VISIBLE
//                forecastListRV.scrollToPosition(0)
            }
        }

    }

    override fun onResume() {
        super.onResume()

        movieInfoViewModel.loadMovieInfo(MOVIEDATABASE_APPID)
    }

    private fun onInfoItemClick(list: MovieList) {
//        val directions = MainActivityFragmentDirections.navigateToForecastDetail(forecastPeriod, forecastAdapter.forecastCity!!)
//        findNavController().navigate(directions)
    }
}