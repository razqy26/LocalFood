package com.razqy26.localfood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListFoodAdapter(private val listfood: ArrayList<Food>) : RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {

    private lateinit var onItemCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_food,parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listfood.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listfood[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener{onItemCallback.onItemClicked(listfood[holder.adapterPosition])}
    }

    interface OnItemClickCallback{
        fun onItemClicked(data : Food)
    }
}