package com.example.eivom.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.activity_person_detail, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_share -> {
                shareContent()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareContent() {
        val shareText = getString(R.string.share_text, args.persondetail.name, args.persondetail.profile_path)
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, shareText)
        startActivity(Intent.createChooser(intent, null))
    }

}