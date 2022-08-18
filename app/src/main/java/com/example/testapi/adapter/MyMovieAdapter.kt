package com.example.testapi.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.testapi.R
import com.example.testapi.model.Movie
import com.squareup.picasso.Picasso

class MyMovieAdapter(private val context: Context, private val movieList: MutableList<Movie>): RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image_movie)
        val txt_name: TextView = itemView.findViewById(R.id.txt_name)
        val txt_team: TextView = itemView.findViewById(R.id.txt_team)
        val txt_createdby: TextView = itemView.findViewById(R.id.txt_createdby)

        fun bind(listItem: Movie){
            image.setOnClickListener {
                Toast.makeText(it.context, "send on ${image}", Toast.LENGTH_SHORT).show()
            }
            itemView.setOnClickListener {
                Toast.makeText(it.context, "send on ${txt_name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        return MyViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]
        holder.bind(listItem)

        Picasso.get().load(movieList[position].imageurl).into(holder.image)
        holder.txt_name.text = movieList[position].name
        holder.txt_team.text = movieList[position].team
        holder.txt_createdby.text = movieList[position].createdby
    }

    override fun getItemCount() = movieList.size
}