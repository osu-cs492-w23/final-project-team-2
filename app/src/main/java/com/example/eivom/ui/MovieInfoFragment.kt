package com.example.eivom.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eivom.R
import com.example.eivom.data.MovieList
import com.example.eivom.data.VideoList
import com.google.android.material.progressindicator.CircularProgressIndicator

class MovieInfoFragment : Fragment(R.layout.movie_info) {
    private val TAG = "MovieInfoFragment"

    private val args: MovieDetailFragmentArgs by navArgs()

    private val movieInfoViewModel : MovieInfoViewModel by viewModels()
    private val infoAdapter = MovieInfoAdapter(::onInfoItemClick)


//  video info API call
    private val videoInfoViewModel : VideoInfoViewModel by viewModels()
    private val videoInfoAdapter = VideoInfoAdapter(::onVideoInfoItemClick)

    private lateinit var movieInfoRV : RecyclerView
    private lateinit var movieInfoRV2 : RecyclerView
    private lateinit var movieInfoRV3 : RecyclerView
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

        movieInfoRV2 = view.findViewById(R.id.rv_movie_info2)
        movieInfoRV2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        movieInfoRV2.setHasFixedSize(true)
        movieInfoRV2.adapter = videoInfoAdapter

        movieInfoRV3 = view.findViewById(R.id.rv_movie_info3)
        movieInfoRV3.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        movieInfoRV3.setHasFixedSize(true)
        movieInfoRV3.adapter = infoAdapter

        //LandingPageViewModel.observe SECTION
        movieInfoViewModel.info.observe(viewLifecycleOwner){info ->
            if(info != null){
                infoAdapter.updateInfo(info)
                movieInfoRV.visibility = View.VISIBLE
                movieInfoRV.scrollToPosition(0)


                movieInfoRV3.visibility = View.VISIBLE
                movieInfoRV3.scrollToPosition(0)
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
                movieInfoRV3.visibility = View.INVISIBLE
            }
            else{
                loadingIndicator.visibility = View.INVISIBLE
            }
        }

// *****    videoInfoViewModel      *****   //
        videoInfoViewModel.info.observe(viewLifecycleOwner){info ->
            if(info != null){
                videoInfoAdapter.updateInfo(info)

                movieInfoRV2.visibility = View.VISIBLE
                movieInfoRV2.scrollToPosition(0)
            }
        }

        videoInfoViewModel.error.observe(viewLifecycleOwner){error ->
            if(error != null){
                loadingErrorTV.text = getString(R.string.loading_error, error.message)
                loadingErrorTV.visibility = View.VISIBLE
                Log.e(TAG, "Error fetching VideoDatabase: ${error.message}")
            }
        }

        videoInfoViewModel.loading.observe(viewLifecycleOwner){loading ->
            if(loading){
                loadingIndicator.visibility = View.VISIBLE
                loadingErrorTV.visibility = View.INVISIBLE
                movieInfoRV2.visibility = View.INVISIBLE
            }
            else{
                loadingIndicator.visibility = View.INVISIBLE
            }
        }

    }
    override fun onResume() {
        super.onResume()

        movieInfoViewModel.loadMovieInfo("1f89bc62d244a63f91c60d7a7381ebd3")
        videoInfoViewModel.loadVideoInfo(157336, "1f89bc62d244a63f91c60d7a7381ebd3")
    }

    private fun onInfoItemClick(list: MovieList) {
        val directions = MovieInfoFragmentDirections.navigateToMovieDetail(list)
        findNavController().navigate(directions)
    }

    private fun onVideoInfoItemClick(list: VideoList){

    }
}