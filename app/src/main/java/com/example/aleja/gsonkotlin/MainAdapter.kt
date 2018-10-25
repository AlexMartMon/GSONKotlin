package com.example.aleja.gsonkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_cell.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>(){


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.nombreEstablecimiento.text = homeFeed.videos[position].name
        holder.view.canal.text = "${homeFeed.videos[position].channel.name}    -   ${homeFeed.videos[position].numberOfViews}K views"
        Picasso.get().load(homeFeed.videos[position].imageUrl).into(holder.view.mainImagen)
        Picasso.get().load(homeFeed.videos[position].channel.profileImageUrl).into(holder.view.imageProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.recycler_cell,parent,false)
        return CustomViewHolder(cellForRow)
    }

    //Retorna numero de objetos
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}