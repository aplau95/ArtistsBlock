//package com.fireapp.andrewlau.myapplication
//
//import android.content.Intent
//import android.os.Bundle
//import android.support.design.widget.FloatingActionButton
//import android.support.v7.app.AlertDialog
//import android.support.v7.app.AppCompatActivity
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import android.widget.Button
//
//import com.example.lab4_masterdetailflow.dummy.ALauDatastore
//import kotlinx.android.synthetic.main.activity_item_detail.*
//import kotlinx.android.synthetic.main.activity_item_list.*
//import kotlinx.android.synthetic.main.add_item.*
//import kotlinx.android.synthetic.main.item_list_content.view.*
//import kotlinx.android.synthetic.main.item_list.*
//import org.w3c.dom.Text
//
///**
// * An activity representing a list of Pings. This activity
// * has different presentations for handset and tablet-size devices. On
// * handsets, the activity presents a list of items, which when touched,
// * lead to a [ItemDetailActivity] representing
// * item details. On tablets, the activity presents the list of items and
// * item details side-by-side using two vertical panes.
// */
//class ItemListActivity : AppCompatActivity() {
//
//    /**
//     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
//     * device.
//     */
//    private var twoPane: Boolean = false
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_item_list)
//
//        setSupportActionBar(toolbar)
//        toolbar.title = title
//
//
//        val addItem = findViewById<FloatingActionButton>(R.id.btnShowDialog)
//        addItem.setOnClickListener {
//
//            val dialog = AlertDialog.Builder(this)
//            val dialogView = layoutInflater.inflate(R.layout.add_item, null)
//            dialog.setView(dialogView)
//            dialog.setCancelable(false)
//            val show = dialog.show()
//
//            val dialogClose = dialogView.findViewById<Button>(R.id.AddItemButtonCancel)
//            val dialogSubmit = dialogView.findViewById<Button>(R.id.addItemButtonSubmit)
//            dialogClose.setOnClickListener {
//                show.dismiss()
//            }
//
//            dialogSubmit.setOnClickListener {
//                val drawItem = ALauDatastore.createDrawItem("asdf", "asdf", "asdf", "asdf")
//                ALauDatastore.addItem(drawItem)
//                show.dismiss()
//            }
//        }
//
//
//
//
//        if (item_detail_container != null) {
//            // The detail container view will be present only in the
//            // large-screen layouts (res/values-w900dp).
//            // If this view is present, then the
//            // activity should be in two-pane mode.
//            twoPane = true
//        }
//
//        setupRecyclerView(item_list)
//    }
//
//    private fun setupRecyclerView(recyclerView: RecyclerView) {
//        recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, ALauDatastore.ITEMS, twoPane)
//    }
//
//
//}
