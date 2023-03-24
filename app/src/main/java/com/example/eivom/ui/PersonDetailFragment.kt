package com.example.eivom.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.eivom.R

class PersonDetailFragment: Fragment(R.layout.person_details_activity) {
    private val args: PersonDetailFragmentArgs by navArgs()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ){
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        view.findViewById<TextView>(R.id.personName).text = getString(R.string.person_name, args.persondetail.name)

        Glide.with(this)
            .load(args.persondetail.profile_path)
            .into(view.findViewById(R.id.personPoster))

        view.findViewById<TextView>(R.id.personPopularity).text = getString(R.string.person_popularity, args.persondetail.popularity)
    }
}