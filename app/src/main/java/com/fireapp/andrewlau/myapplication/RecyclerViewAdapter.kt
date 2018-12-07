package com.fireapp.andrewlau.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.lab4_masterdetailflow.dummy.ALauDatastore
import kotlinx.android.synthetic.main.item_list_content.view.*

class RecyclerViewAdapter(private val parentActivity: ItemListFragment, private val values: List<ALauDatastore.DrawItem>, private val twoPane: Boolean) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return values.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.imageView.setImageBitmap(item.imageBitMap)
        holder.dateText.text = item.date
        holder.imageDesc.text = item.desc
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.itemListImageDisplay
        val imageDesc : TextView = itemView.textDesc
        val dateText : TextView = itemView.textDate


    }
}