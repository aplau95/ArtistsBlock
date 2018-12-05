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
import android.widget.TextView
import com.fireapp.andrewlau.myapplication.ImageList.imageList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_swatch.*
import java.util.Random


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment3 : Fragment() {
    private val CAMERA_PIC_REQUEST = 1337
    val unsplashApiLink = "https://api.unsplash.com/photos/random?client_id=bc37901814227d25f99ac03155e0e111c458e496b2d2bd6a14dab630e5568247&count=30"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_swatch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (ImageList.currentImageObject != null){
            updateImage(ImageList.currentImageObject!!)
        }

        val getImage = getView()!!.findViewById(R.id.NextImage) as Button

        getImage.setOnClickListener() {
            updateImage(ImageList.imageList!!.pop())
            if (ImageList.imageList!!.size < 5) {
                GetImageAsyncTask().execute(unsplashApiLink)
            }
        }
    }

    private fun initializeDescText(){
        if (ImageList.currentImageObject!!.description.isNullOrEmpty()){
            ImageDesc.text = "No description available"
        } else {
            ImageDesc.text = ImageList.currentImageObject!!.description
        }
    }

    private fun updateImage(imageObj : ImageObject) {
        ImageList.currentImageObject = imageObj
        Picasso.get()
            .load(imageObj.urls?.full)
            .fit()
            .into(imageDisplay)
        initializeDescText()
    }




}
