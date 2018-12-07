package com.fireapp.andrewlau.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lab4_masterdetailflow.dummy.ALauDatastore
import kotlinx.android.synthetic.main.item_list_content.view.*

class RecyclerViewAdapter(private val parentActivity: ItemListFragment, private val values: List<ALauDatastore.DrawItem>, private val twoPane: Boolean) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

//    private val onClickListener: View.OnClickListener
//    init {
//        onClickListener = View.OnClickListener { v ->
//            val item = v.tag as ALauDatastore.DrawItem
//            if (twoPane) {
//                val fragment = ItemDetailFragment().apply {
//                    arguments = Bundle().apply {
//                        putString(ItemDetailFragment.ARG_ITEM_ID, item.id)
//                    }
//                }
//                parentActivity.supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.item_detail_container, fragment)
//                    .commit()
//            } else {
//                val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
//                    putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id)
//                }
//                v.context.startActivity(intent)
//            }
//        }
//    }

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
        holder.idView.text = item.id
        holder.titleView.text = item.title
        holder.mediumView.text = "Your art medium is: " + item.medium
        holder.actionView.text = "Make the piece " + item.action
        holder.definitionView.text = "Definition: " + item.definition


//        with(holder.itemView) {
//            tag = item
//            setOnClickListener(onClickListener)
//        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idView: TextView = itemView.id_text
        val titleView: TextView = itemView.titleText
        val mediumView: TextView = itemView.mediumText
        val actionView: TextView = itemView.actionText
        val definitionView: TextView = itemView.definitionText

    }
}