package com.example.filestorageexample



import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_list_movie.*


class ListMovie:AppCompatActivity() {

    private lateinit var mMovieViewModel: MovieViewModel
    lateinit var adapter : ListAdapter
    var movie: List<Movie> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)

        setUp()

    }

    private fun setUp() {
        initRecyclerView()
        mMovieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        mMovieViewModel.readAllData.observe(this, Observer { Movie ->
            this.movie=movie
            adapter.setData(movie)
        })

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this,AddMovie::class.java))
        }
    }

    private fun initRecyclerView() {
        adapter = ListAdapter(){
            navigateToUpdateActivity(movie[it])
        }
        recycleView?.adapter = adapter
        recycleView?.layoutManager = LinearLayoutManager(this)
    }

    private fun navigateToUpdateActivity(movie: Movie) {
        val intent=Intent(this,UpdateUser::class.java)
        intent.putExtra(BundleConstants.navigateToUpdate,movie)
        startActivity(intent)
    }



//    private fun deleteAllUsers() {
//        val builder = AlertDialog.Builder(this)
//        builder.setPositiveButton("Yes") { _, _ ->
//            mMovieViewModel.deleteAllMovie()
//            Toast.makeText(
//                this,
//                "Successfully removed everything",
//                Toast.LENGTH_SHORT).show()
//        }
//        builder.setNegativeButton("No") { _, _ -> }
//        builder.setTitle("Delete everything?")
//        builder.setMessage("Are you sure you want to delete everything?")
//        builder.create().show()
//    }
}