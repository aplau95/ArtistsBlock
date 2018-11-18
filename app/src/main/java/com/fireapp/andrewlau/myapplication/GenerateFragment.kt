package com.fireapp.andrewlau.myapplication


import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_generate.*
import android.content.Intent
import com.squareup.picasso.Picasso


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class GenerateFragment : Fragment() {

    var category = "Art"
    private val CAMERA_PIC_REQUEST = 1337

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_generate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        wordDisplay.text = currentWord.WORD
        if (currentWord.IMAGEURL != ""){
            Picasso.get().load(currentWord.IMAGEURL).into(wordImage)
        }
        val getWord = getView()!!.findViewById(R.id.getWordButton) as Button
        val camButton = getView()!!.findViewById(R.id.cameraButton) as FloatingActionButton

        getWord.setOnClickListener {
            val jsonUrlString = wordlist()

            GetOxfordAsyncTask(::updateWord).execute(jsonUrlString)
        }
        camButton.setOnClickListener {
            val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST)
        }
    }

    private fun updateImage(imageURL : String) {
        Picasso.get().load(imageURL).into(wordImage)
    }

    private fun updateDefinition(definition : String) {
        println(definition)
    }

    private fun updateWord(newWord : String) {
        wordDisplay.text = newWord
        GetImageAsyncTask(::updateImage).execute(imageLink(newWord))
//        GetDefinitionAsyncTask(::updateDefinition).execute(defLink(newWord))

    }

    private fun imageLink(wordLookup : String) : String {
        val parsableString = wordLookup.replace(" ", "+")
        return "https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI?count=1&q=$parsableString&autoCorrect=false"
    }

    private fun wordlist(): String {
        val language = "en"
        val filters = "registers=Rare;domains=Art"
        return "https://od-api.oxforddictionaries.com:443/api/v1/wordlist/$language/$filters?limit=1"
    }

    private fun defLink(word : String): String {
        val language = "en"
        val parsableString = word.replace(" ", "_")
        return "https://od-api.oxforddictionaries.com:443/api/v1/wordlist/$language/$word"
    }


}
