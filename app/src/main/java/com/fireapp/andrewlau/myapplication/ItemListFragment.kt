package com.fireapp.andrewlau.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.lab4_masterdetailflow.dummy.ALauDatastore
import kotlinx.android.synthetic.main.activity_item_list.*


/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_item_list, container, false)
        val rv = v.findViewById<RecyclerView>(R.id.item_list)

        rv.adapter = RecyclerViewAdapter(this, ALauDatastore.ITEMS, false)
        return v
    }
}
