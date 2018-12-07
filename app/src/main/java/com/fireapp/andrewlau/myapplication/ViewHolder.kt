package com.fireapp.andrewlau.myapplication

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_list_content.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val idView: TextView = view.id_text
    val titleView: TextView = view.titleText
    val mediumView: TextView = view.mediumText
    val actionView: TextView = view.actionText
    val definitionView: TextView = view.definitionText

}