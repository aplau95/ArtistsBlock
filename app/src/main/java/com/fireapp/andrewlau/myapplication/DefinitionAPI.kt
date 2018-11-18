package com.fireapp.andrewlau.myapplication

import android.os.AsyncTask
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL
import okhttp3.OkHttpClient
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.net.ssl.HttpsURLConnection


class GetDefinitionAsyncTask(private val callback : (newWord : String) -> Unit) : AsyncTask<String, String, String>() {
    var client = OkHttpClient()
    var category: String? = null

    fun changeCategory(category : String) {
        this.category = category
    }


    override fun doInBackground(vararg params: String): String {

        //TODO: replace with your own app id and app key
        val app_id = "111aab88"
        val app_key = "78ff37165f7543bcb86ee546b7e8e8c3"
        var definition = ""
        try {
            val url = URL(params[0])
            val urlConnection = url.openConnection() as HttpsURLConnection
            urlConnection.setRequestProperty("Accept", "application/json")
            urlConnection.setRequestProperty("app_id", app_id)
            urlConnection.setRequestProperty("app_key", app_key)

            val inString = urlConnection.inputStream.bufferedReader().readText()
            var wordData = Gson().fromJson(inString, DefinitionJson::class.java)
            definition = wordData.generateDefinition()
            println(definition)
            publishProgress(inString)

        } catch (e: Exception) {
            e.printStackTrace()
            return e.toString()
        }

        return definition

    }

    override fun onProgressUpdate(vararg values: String?) {
        try {


        } catch (ex: Exception) {
            println("JSON parsing exception" + ex.printStackTrace())
        }
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        currentWord.DEFINITION = result
        callback(result)
        println(result)
    }



}