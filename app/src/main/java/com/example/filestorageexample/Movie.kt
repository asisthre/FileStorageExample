package com.example.filestorageexample

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val releaseYear: Int
): Parcelable