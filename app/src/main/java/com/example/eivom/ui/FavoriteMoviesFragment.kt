package com.example.eivom.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.eivom.R

class FavoriteMoviesFragment: Fragment(R.layout.favorite_movie_fragment) {
    private val args: FavoriteMoviesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<TextView>(R.id.tv_favorite_movie_title).text = getString(
//            R.string.movie_title,
//            args.favorites.title
//        )
    }
}