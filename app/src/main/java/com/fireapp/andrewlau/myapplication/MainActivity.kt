package com.fireapp.andrewlau.myapplication

import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.fireapp.andrewlau.myapplication.ImageList.imageList
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                createFragmentOne()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                createFragmentTwo()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createFragmentOne()



        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


    fun createFragmentOne() {
        val transaction = manager.beginTransaction()
        val fragment = GenerateFragment()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentTwo() {
        val transaction = manager.beginTransaction()
        val fragment = ItemListFragment()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
