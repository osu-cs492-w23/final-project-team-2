package com.example.eivom.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eivom.R
import com.example.eivom.data.MovieInfo
import com.google.android.material.progressindicator.CircularProgressIndicator

class MovieInfoFragment : Fragment() {
    private val TAG = "MovieInfoFragment"

    private val movieInfoViewModel : MovieInfoViewModel by viewModels()
//    private val movieInfoAdapter = MovieInfoAdapter(::onMovieInfoClick)

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
//        movieInfoRV.adapter = MovieInfoAdapter

        //LandingPageViewModel.observe SECTION
        movieInfoViewModel.info.observe(viewLifecycleOwner){info ->
            if(info != null){
//                movieInfoAdapter.updatemovieInfo(info)
                movieInfoRV.visibility = View.VISIBLE
                movieInfoRV.scrollToPosition(0)
//                (requireActivity() as AppCompatActivity).supportActionBar?.title = info
            }
        }

        movieInfoViewModel.error.observe(viewLifecycleOwner){error ->
            if(error != null){
                loadingErrorTV.text = getString(R.string.loading_error, error.message)
                loadingErrorTV.visibility = View.VISIBLE
                Log.e(TAG, "Error fetching forecast: ${error.message}")
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

    override fun onResume(){
        super.onResume()


    }

    private fun onMovieInfoClick(){

    }
}