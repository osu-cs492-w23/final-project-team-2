package com.example.eivom.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.eivom.R
import com.example.eivom.`data`.MovieList
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class MovieInfoFragmentDirections private constructor() {
  private data class NavigateToMovieDetail(
    public val moviedetail: MovieList
  ) : NavDirections {
    public override val actionId: Int = R.id.navigate_to_movie_detail

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(MovieList::class.java)) {
          result.putParcelable("moviedetail", this.moviedetail as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(MovieList::class.java)) {
          result.putSerializable("moviedetail", this.moviedetail as Serializable)
        } else {
          throw UnsupportedOperationException(MovieList::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun navigateToMovieDetail(moviedetail: MovieList): NavDirections =
        NavigateToMovieDetail(moviedetail)
  }
}
