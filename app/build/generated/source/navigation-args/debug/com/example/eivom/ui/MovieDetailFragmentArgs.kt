package com.example.eivom.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.eivom.`data`.MovieList
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class MovieDetailFragmentArgs(
  public val moviedetail: MovieList
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(MovieList::class.java)) {
      result.set("moviedetail", this.moviedetail as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(MovieList::class.java)) {
      result.set("moviedetail", this.moviedetail as Serializable)
    } else {
      throw UnsupportedOperationException(MovieList::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): MovieDetailFragmentArgs {
      bundle.setClassLoader(MovieDetailFragmentArgs::class.java.classLoader)
      val __moviedetail : MovieList?
      if (bundle.containsKey("moviedetail")) {
        if (Parcelable::class.java.isAssignableFrom(MovieList::class.java) ||
            Serializable::class.java.isAssignableFrom(MovieList::class.java)) {
          __moviedetail = bundle.get("moviedetail") as MovieList?
        } else {
          throw UnsupportedOperationException(MovieList::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__moviedetail == null) {
          throw IllegalArgumentException("Argument \"moviedetail\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"moviedetail\" is missing and does not have an android:defaultValue")
      }
      return MovieDetailFragmentArgs(__moviedetail)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): MovieDetailFragmentArgs {
      val __moviedetail : MovieList?
      if (savedStateHandle.contains("moviedetail")) {
        if (Parcelable::class.java.isAssignableFrom(MovieList::class.java) ||
            Serializable::class.java.isAssignableFrom(MovieList::class.java)) {
          __moviedetail = savedStateHandle.get<MovieList?>("moviedetail")
        } else {
          throw UnsupportedOperationException(MovieList::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__moviedetail == null) {
          throw IllegalArgumentException("Argument \"moviedetail\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"moviedetail\" is missing and does not have an android:defaultValue")
      }
      return MovieDetailFragmentArgs(__moviedetail)
    }
  }
}
