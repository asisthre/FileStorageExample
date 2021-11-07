package com.example.filestorageexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MovieViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Movie>>
    private val repository: MovieRepository

    init {
        val MovieDao = MovieDatabase.getDatabase(
            application
        ).MovieDao()
        repository = MovieRepository(MovieDao)
        readAllData = repository.readAllData
    }

    fun addMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMovie(movie)
        }
    }

    fun updateMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateMovie(movie)
        }
    }
    fun deleteMovie(movie: Movie){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteMovie(movie)
        }
    }

    fun deleteAllMovie(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllMovie()
        }
    }
}