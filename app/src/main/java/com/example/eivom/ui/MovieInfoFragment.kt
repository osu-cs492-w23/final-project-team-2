package com.example.eivom.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eivom.R
import com.example.eivom.data.MovieInfo
import com.example.eivom.data.MovieList
import com.google.android.material.progressindicator.CircularProgressIndicator

class MovieInfoFragment : Fragment(R.layout.movie_info) {
    private val TAG = "MovieInfoFragment"

    private val movieInfoViewModel : MovieInfoViewModel by viewModels()
    private val infoAdapter = MovieInfoAdapter(::onInfoItemClick)

    private lateinit var movieInfoRV : RecyclerView
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

        //LandingPageViewModel.observe SECTION
        movieInfoViewModel.info.observe(viewLifecycleOwner){info ->
            if(info != null){
                infoAdapter.updateInfo(info)
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
    }
    override fun onResume() {
        super.onResume()

        movieInfoViewModel.loadMovieInfo("1f89bc62d244a63f91c60d7a7381ebd3")
    }

    private fun onInfoItemClick(list: MovieList) {
        val directions = MovieInfoFragmentDirections.navigateToMovieDetail(list)
        findNavController().navigate(directions)
    }
}