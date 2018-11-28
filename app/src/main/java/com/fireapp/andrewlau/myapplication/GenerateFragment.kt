package com.fireapp.andrewlau.myapplication


import android.content.ClipDescription
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
import java.util.Random


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


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
        definitionText.text = currentWord.DEFINITION
        if (currentWord.IMAGEURL != ""){
            println("!!!!!!!!!!!!!!!!!!!!!!")
            Picasso.get()
                .load(currentWord.IMAGEURL)
                .fit()
                .into(wordImage)
        }
        val getImage = getView()!!.findViewById(R.id.getWordButton) as Button
        val camButton = getView()!!.findViewById(R.id.cameraButton) as FloatingActionButton

        getImage.setOnClickListener {


            GetOxfordAsyncTask(::updateWord).execute(jsonUrlString)
        }

//        camButton.setOnClickListener {
//            val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST)
//        }
    }

    private fun updateImage(imageURL : String, description: String) {
        Picasso.get().load(imageURL)
            .fit()
            .into(wordImage)
        currentImage.IMAGEURL = imageURL
    }


    private fun updateWord(newWord : String) {
        val unsplashApiLink = "https://api.unsplash.com/photos/random?client_id=bc37901814227d25f99ac03155e0e111c458e496b2d2bd6a14dab630e5568247"
        GetImageAsyncTask(::updateImage).execute(unsplashApiLink)

    }


}
