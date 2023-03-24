package com.example.eivom.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.eivom.R

class TvShowDetailFragment: Fragment() {

    private val args: TvShowDetailFragmentArgs by navArgs()

    private val favoriteViewModel: FavoriteMoviesViewModel by viewModels()
    private var isLiked = false

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.activity_movie_detail, menu)
//
//        val button = menu.findItem(R.id.action_favorite)
//        favoriteViewModel.getMovieByName(args.moviedetail.title).observe(viewLifecycleOwner) { movie ->
//            when (movie) {
//                null -> {
//                    favoriteViewModel.removeFavoriteMovie(args.moviedetail)
//                    isLiked = false
//                    button.isChecked = false
//                    button.icon = AppCompatResources.getDrawable(
//                        requireContext(),
//                        R.drawable.ic_not_favorite_36
//                    )
//                }
//                else -> {
//                    favoriteViewModel.addFavoriteMovie(args.moviedetail)
//                    isLiked = true
//                    button.isChecked = true
//                    button.icon = AppCompatResources.getDrawable(
//                        requireContext(),
//                        R.drawable.ic_favorite_36
//                    )
//                }
//            }
//        }
//    }
}