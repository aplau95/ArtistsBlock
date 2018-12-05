package com.fireapp.andrewlau.myapplication

import android.media.Image
import android.os.AsyncTask
import com.fireapp.andrewlau.myapplication.ImageList.imageList
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL
import okhttp3.OkHttpClient
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.net.ssl.HttpsURLConnection


class UpdateImage : AsyncTask<String, String, String>() {
    override fun doInBackground(vararg params: String): String {

        try {

        } catch (e: Exception) {
            e.printStackTrace()
            return e.toString()
        }


        return ""

    }

    override fun onProgressUpdate(vararg values: String?) {
        try {


        } catch (ex: Exception) {
            println("JSON parsing exception" + ex.printStackTrace())
        }
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
    }



}