package com.example.filestorageexample

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_add_movie.*


class AddMovie:AppCompatActivity() {
    private lateinit var mMovieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_movie)

        setUp()
    }

    private fun setUp() {
        mMovieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        add_btn.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val name = addName_et.text.toString()
        val releaseDate = addReleaseYear_et.text

        if(inputCheck(name, releaseDate)){
            // Create Movie Object
            val movie = Movie(
                0,
                name,
                Integer.parseInt(releaseDate.toString())
            )
            // Add Data to Database
            mMovieViewModel.addMovie(movie)
            Toast.makeText(this, "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            finish()
        }else{
            Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, releaseYear: Editable): Boolean{
        return !(TextUtils.isEmpty(name) && releaseYear.isEmpty())
    }
}