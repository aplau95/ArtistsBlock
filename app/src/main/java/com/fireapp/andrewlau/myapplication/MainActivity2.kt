package com.fireapp.andrewlau.myapplication

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.util.Log
import com.fireapp.andrewlau.myapplication.ImageList.imageList
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_swatch.*


class MainActivity2 : AppCompatActivity(){
    val unsplashApiLink = "https://api.unsplash.com/photos/random?client_id=bc37901814227d25f99ac03155e0e111c458e496b2d2bd6a14dab630e5568247&count=30&orientation=landscape&featured"
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_swatch)

        GetImageAsyncTask(::updateInfo).execute(unsplashApiLink)

        CompleteButton.setOnClickListener {
            openFinishFragment()
        }

        NextImage.setOnClickListener() {
            if (ImageList.imageList.size < 3){
                GetImageAsyncTask(::updateInfo).execute(unsplashApiLink)
            } else {
                UpdateImageAsyncTask(::updateInfo).execute()
            }
        }

        imageDisplay.setOnClickListener() {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(ImageList.currentImage))
            startActivity(browserIntent)
        }
    }


    private fun initializeDescText(imageDesc : String){
        ImageDesc.text = imageDesc
    }


    private fun updateInfo(imageUrl : String, imageDesc : String, imageBitmap : Bitmap) {
        Picasso.get()
            .load(imageUrl)
            .resize(0, imageDisplay.height)
            .into(imageDisplay)
        initializeDescText(imageDesc)
        createPalette(imageBitmap)
    }

    private fun createPalette(bitmap: Bitmap) {
        val numPixels = bitmap.height * bitmap.width
        println("NUMBER OF PIXELS " + numPixels.toString())
        Palette.from(bitmap).generate { palette ->
            val defaultValue = 0x000000
            val c1 = palette!!.swatches[0].rgb
            val c2 = palette!!.swatches[1].rgb
            val c3 = palette!!.swatches[2].rgb
            val c4 = palette!!.swatches[3].rgb
            val c5 = palette!!.swatches[4].rgb
            val c6 = palette!!.swatches[5].rgb
            val c7 = palette!!.swatches[6].rgb
            val c8 = palette!!.swatches[7].rgb
            val c9 = palette!!.swatches[8].rgb


            vibrantView.setBackgroundColor(c1)
            vibrantView.text = String.format("#%06X", 0xFFFFFF and c1)

            vibrantLightView.setBackgroundColor(c2)
            vibrantLightView.text = String.format("#%06X", 0xFFFFFF and c2)

            vibrantDarkView.setBackgroundColor(c3)
            vibrantDarkView.text = String.format("#%06X", 0xFFFFFF and c3)

            mutedView.setBackgroundColor(c4)
            mutedView.text = String.format("#%06X", 0xFFFFFF and c4)

            mutedLightView.setBackgroundColor(c5)
            mutedLightView.text = String.format("#%06X", 0xFFFFFF and c5)

            mutedDarkView.setBackgroundColor(c6)
            mutedDarkView.text = String.format("#%06X", 0xFFFFFF and c6)

            mutedView2.setBackgroundColor(c7)
            mutedView2.text = String.format("#%06X", 0xFFFFFF and c7)

            mutedLightView2.setBackgroundColor(c8)
            mutedLightView2.text = String.format("#%06X", 0xFFFFFF and c8)

            mutedDarkView2.setBackgroundColor(c9)
            mutedDarkView2.text = String.format("#%06X", 0xFFFFFF and c9)


        }
    }

    private fun openFinishFragment() {
        val dialog = OpenFinishFrag()
        dialog.show(manager, "name")
    }
}
