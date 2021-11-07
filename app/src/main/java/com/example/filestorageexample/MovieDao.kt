package com.example.filestorageexample

import androidx.lifecycle.LiveData
import androidx.room.*

object MovieDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addMovie(movie: Movie)

    @Update
    suspend fun updateMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovie()

    @Query("SELECT * FROM movie_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Movie>>

}