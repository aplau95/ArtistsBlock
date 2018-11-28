package com.fireapp.andrewlau.myapplication

import android.os.AsyncTask
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL
import okhttp3.OkHttpClient
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.net.ssl.HttpsURLConnection


class GetImageAsyncTask(private val callback : (newWord : String) -> Unit) : AsyncTask<String, String, String>() {
    override fun doInBackground(vararg params: String): String {


        var imageUrl = ""
        val key = "BRngMhI744mshcXkxyMvXnm5HtLvp1zk6AgjsnkKmFjwKDnPjN"
        val host = "contextualwebsearch-websearch-v1.p.rapidapi.com"
        try {
            val url = URL(params[0])
            val urlConnection = url.openConnection() as HttpsURLConnection
            urlConnection.setRequestProperty("Accept", "application/json")
            urlConnection.setRequestProperty("X-Mashape-Key", key)
            urlConnection.setRequestProperty("X-Mashape-Host", host)

            val inString = urlConnection.inputStream.bufferedReader().readText()
            println("!@#!@$#!@$!@$!@$!@$@!$" + inString)
            var imageData = Gson().fromJson(inString, ImageJson::class.java)
            imageUrl = imageData.generateImageUrl()
            publishProgress(inString)

        } catch (e: Exception) {
            e.printStackTrace()
            return e.toString()
        }

        return imageUrl

    }

    override fun onProgressUpdate(vararg values: String?) {
        try {


        } catch (ex: Exception) {
            println("JSON parsing exception" + ex.printStackTrace())
        }
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        currentWord.IMAGEURL = result
        callback(result)
        println(result)
    }



}