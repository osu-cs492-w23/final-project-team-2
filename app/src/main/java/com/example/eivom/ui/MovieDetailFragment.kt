package com.example.eivom.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.eivom.R

class MovieDetailFragment : Fragment(R.layout.movie_details_activity) {
    private val args: MovieDetailFragmentArgs by navArgs()
    private val favoriteViewModel: FavoriteMoviesViewModel by viewModels()

    private var isLiked = false

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        view.findViewById<TextView>(R.id.movieTitle).text = getString(R.string.movie_title, args.moviedetail.title)

        Glide.with(this)
            .load(args.moviedetail.poster_path)
            .into(view.findViewById(R.id.moviePoster))

        view.findViewById<TextView>(R.id.movieDescription).text = getString(R.string.movie_description, args.moviedetail.overview)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.activity_movie_detail, menu)

        val button = menu.findItem(R.id.action_favorite)
        favoriteViewModel.getMovieByName(args.moviedetail.title).observe(viewLifecycleOwner) { movie ->
            when (movie) {
                null -> {
                    favoriteViewModel.removeFavoriteMovie(args.moviedetail)
                    isLiked = false
                    button.isChecked = false
                    button.icon = AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.ic_not_favorite_36
                    )
                }
                else -> {
                    favoriteViewModel.addFavoriteMovie(args.moviedetail)
                    isLiked = true
                    button.isChecked = true
                    button.icon = AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.ic_favorite_36
                    )
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_favorite -> {
                toggleMovieFavorite(item)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toggleMovieFavorite (menuItem: MenuItem) {
        when (isLiked) {
            false -> {
                favoriteViewModel.addFavoriteMovie(args.moviedetail)
            }
            true -> favoriteViewModel.removeFavoriteMovie(args.moviedetail)
        }
    }
}