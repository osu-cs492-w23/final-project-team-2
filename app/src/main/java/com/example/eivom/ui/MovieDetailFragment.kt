package com.example.eivom.ui

import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.eivom.R
import org.w3c.dom.Text

class MovieDetailFragment : Fragment(R.layout.movie_details_activity) {
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.movieTitle).text = getString(R.string.movie_title, args.moviedetail.title)

        Glide.with(this)
            .load(args.moviedetail.poster_path)
            .into(view.findViewById(R.id.moviePoster))

        view.findViewById<TextView>(R.id.movieDescription).text = getString(R.string.movie_description, args.moviedetail.overview)

    }
}