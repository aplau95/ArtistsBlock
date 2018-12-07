package com.fireapp.andrewlau.myapplication

import android.graphics.BitmapFactory
import android.graphics.Bitmap
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class Utils {
    companion object {
        fun getBitmapFromURL(src: String?): Bitmap? {
            try {
                val url = URL(src)
                val connection = url.openConnection() as HttpURLConnection
                connection.setDoInput(true)
                connection.connect()
                val input = connection.getInputStream()
                return BitmapFactory.decodeStream(input)
            } catch (e: IOException) {
                e.printStackTrace()
                return null
            }

        }
    }
}