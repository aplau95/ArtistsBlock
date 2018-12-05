package com.fireapp.andrewlau.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.AsyncTask
import com.fireapp.andrewlau.myapplication.ImageList.imageList
import com.fireapp.andrewlau.myapplication.Utils.Companion.getBitmapFromURL
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL
import okhttp3.OkHttpClient
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import javax.net.ssl.HttpsURLConnection


class UpdateImageAsyncTask(private val callback : (newImageUrl : String, newImageDesc : String, newBitmap : Bitmap) -> Unit) : AsyncTask<String, String, String>() {
    override fun doInBackground(vararg params: String): String {

        try {

            try {
                val url = URL(ImageList.imageList!!.peek().urls!!.full)
                val connection = url.openConnection() as HttpURLConnection
                connection.setDoInput(true)
                connection.connect()
                val input = connection.getInputStream()
                ImageList.currentBitMap = BitmapFactory.decodeStream(input)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            publishProgress()

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

    override fun onPostExecute(result: String?) {

        val io = ImageList.imageList!!.pop()
        var imageDesc = "no description available"
        if (!io.description.isNullOrEmpty()) {
            imageDesc = io.description
        }
        callback(io.urls!!.full!!, imageDesc, ImageList.currentBitMap!!)
    }



}