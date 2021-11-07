package com.example.filestorageexample


import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_update_movie.*


class UpdateUser:AppCompatActivity() {

    private lateinit var mMovieViewModel: MovieViewModel
    var movie:Movie?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_update_movie)

        setUp()
    }

    private fun setUp() {
        mMovieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        movie=intent?.getParcelableExtra(BundleConstants.navigateToUpdate)
        updateName_et.setText(movie?.name)
        updateReleaseYear_et.setText(movie?.releaseYear.toString())
        update_btn.setOnClickListener {
            updateItem()
        }
    }

    private fun updateItem() {
        val name = updateName_et.text.toString()
        val releaseYear= Integer.parseInt(updateReleaseYear_et.text.toString())

        if (inputCheck(name, updateReleaseYear_et.text)) {
            // Create Movie Object
            val updatedMovie = Movie(movie?.id?:0, name, releaseYear)
            // Update Current movie
            mMovieViewModel.updateMovie(updatedMovie)
            Toast.makeText(this, "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            finish()
        } else {
            Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun inputCheck(name: String, releaseYear: Editable): Boolean {
        return !(TextUtils.isEmpty(name)  && releaseYear.isEmpty())
    }

//    private fun deleteUser() {
//        val builder = AlertDialog.Builder(this)
//        builder.setPositiveButton("Yes") { _, _ ->
//            mMovieViewModel.deleteMovie(movie)
//            Toast.makeText(
//                this,
//                "Successfully removed: ${movie?.name}",
//                Toast.LENGTH_SHORT).show()
//            finish()
//        }
//        builder.setNegativeButton("No") { _, _ -> }
//        builder.setTitle("Delete ${movie?.name}")
//        builder.setMessage("Are you sure you want to delete ${movie?.name}?")
//        builder.create().show()
//    }
}