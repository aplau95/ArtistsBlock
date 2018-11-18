package com.fireapp.andrewlau.myapplication

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {

    var category = "Art"

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val getWord = findViewById(R.id.getWordButton) as Button
        getWord.setOnClickListener {
            val appKey = "78ff37165f7543bcb86ee546b7e8e8c3"
            val language = "en"
            val filters = "lexicalCategory=noun;domains=${this.category}"
            val limit = "?limit=2"
            val jsonUrlString = wordlist()

            GetOxfordAsyncTask(::updateWord).execute(jsonUrlString)
        }

    }

    private fun updateWord(newWord : String) {
        WordDisplay.text = newWord
    }

    private fun wordlist(): String {
        val language = "en"
        val filters = "registers=Rare;domains=Art"
        return "https://od-api.oxforddictionaries.com:443/api/v1/wordlist/$language/$filters?limit=2"
    }
}
