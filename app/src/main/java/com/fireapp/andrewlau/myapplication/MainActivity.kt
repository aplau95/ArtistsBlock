package com.fireapp.andrewlau.myapplication

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    // Using Oxford dictionary api using callbacks to update  ui when the async task completes. Using contextualapi to
    // image search. Does not always yield results so i'm looking to switch to a more reliable api.
    // Looking into solutions for lag. Possibly preload results into a queue and have generate idea pop the new idea
    // off the queue. Need to improve the generate idea view to create an instance the draw idea to add to a recycler
    // view. Need to implement the recycler view into a fragment that can be tabbed to. Going to need to modify code
    // from lab5. Login screen and signup view need to be implemented in order to take advantage of firebase.
    // NOTE: there is a limit to a number of api calls a minute (5). If exceeded, an error will be thrown
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
            R.id.navigation_notifications -> {
                createFragmentThree()
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
        val fragment = BlankFragment2()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentThree() {
        val transaction = manager.beginTransaction()
        val fragment = BlankFragment3()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
