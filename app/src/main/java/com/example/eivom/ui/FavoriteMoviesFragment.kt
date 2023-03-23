package com.example.eivom.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eivom.R
import com.example.eivom.data.MovieList

class FavoriteMoviesFragment: Fragment(R.layout.favorite_movie_fragment) {
    private val args: MovieDetailFragmentArgs by navArgs()

    private val favoriteViewModel: FavoriteMoviesViewModel by viewModels()
    private val favoriteMovieAdapter = MovieInfoAdapter(::onFavoriteMovieClick)
    private lateinit var favoriteMovieRV: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
         * Set up RecyclerView
         */
        favoriteMovieRV = view.findViewById(R.id.rv_favorite_movies)
        favoriteMovieRV.layoutManager = LinearLayoutManager(requireContext())
        favoriteMovieRV.setHasFixedSize(true)
        favoriteMovieRV.adapter = favoriteMovieAdapter

        favoriteViewModel.favoriteMovies.observe(viewLifecycleOwner) {
            favoriteMovieAdapter.updateInfo(it)
        }
    }

    private fun onFavoriteMovieClick(movie: MovieList) {
        val directions = FavoriteMoviesFragmentDirections.navigateToMovieDetail(movie)
        findNavController().navigate(directions)
    }
}