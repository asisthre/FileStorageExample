package com.example.filestorageexample

import androidx.lifecycle.LiveData

class MovieRepository(private val movieDao: MovieDao) {

    val readAllData: LiveData<List<Movie>> = MovieDao.readAllData()

    suspend fun addMovie(movie: Movie){
        movieDao.addMovie(movie)
    }

    suspend fun updateMovie(movie: Movie){
        movieDao.updateMovie(movie)
    }

    suspend fun deleteMovie(movie: Movie){
        movieDao.deleteMovie(movie)
    }

    suspend fun deleteAllMovie(){
        movieDao.deleteAllMovie()
    }

}