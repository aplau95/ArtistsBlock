package com.fireapp.andrewlau.myapplication

import android.os.AsyncTask
import com.google.gson.Gson
import java.net.URL
import okhttp3.OkHttpClient
import javax.net.ssl.HttpsURLConnection
import java.util.Random


class GetOxfordAsyncTask(private val callback : (newWord : String) -> Unit) : AsyncTask<String, String, String>() {
    var client = OkHttpClient()
    var category: String? = null

    fun changeCategory(category : String) {
        this.category = category
    }


    override fun doInBackground(vararg params: String): String {

        //TODO: replace with your own app id and app key
        val app_id = "111aab88"
        val app_key = "78ff37165f7543bcb86ee546b7e8e8c3"
        var word = ""
        var size : Int? = null
        try {
            var url = URL(params[0])
            var urlConnection = url.openConnection() as HttpsURLConnection
            urlConnection.setRequestProperty("Accept", "application/json")
            urlConnection.setRequestProperty("app_id", app_id)
            urlConnection.setRequestProperty("app_key", app_key)

            var inString = urlConnection.inputStream.bufferedReader().readText()
            var wordData = Gson().fromJson(inString, CompleteJson::class.java)
            size = wordData.getSize()
            val random = Random()
            val randomIndex = random.nextInt(size) - 1


            url = URL(params[0] + "&offset=$randomIndex")
            println("!!!!!!!!!!!!!!!!!" + url)
            urlConnection = url.openConnection() as HttpsURLConnection
            urlConnection.setRequestProperty("Accept", "application/json")
            urlConnection.setRequestProperty("app_id", app_id)
            urlConnection.setRequestProperty("app_key", app_key)

            inString = urlConnection.inputStream.bufferedReader().readText()
            wordData = Gson().fromJson(inString, CompleteJson::class.java)
            word = wordData.generateWords()
            println("!!!!!!!!!!!!"+ word)
            publishProgress(inString)


        } catch (e: Exception) {
            e.printStackTrace()
            return e.toString()
        }

        return word

    }

    override fun onProgressUpdate(vararg values: String?) {
        try {


        } catch (ex: Exception) {
            println("JSON parsing exception" + ex.printStackTrace())
        }
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        currentWord.WORD = result
        callback(result)
        println(result)
    }



}