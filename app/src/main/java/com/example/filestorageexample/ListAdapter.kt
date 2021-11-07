package com.example.filestorageexample


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_row.view.*


class ListAdapter(private val onItemClicked: (position: Int) -> Unit?): RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var movieList = emptyList<Movie>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.Name_txt.text = currentItem.name
        holder.itemView.releaseDate_txt.text = currentItem.releaseYear.toString()

        holder.itemView.rowLayout.setOnClickListener {
            onItemClicked(position)
        }
    }

    fun setData(movie: List<Movie>){
        this.movieList = movie
        notifyDataSetChanged()
    }
}