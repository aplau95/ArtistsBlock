package com.fireapp.andrewlau.myapplication


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
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
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.support.v7.graphics.Palette
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.fireapp.andrewlau.myapplication.ImageList.currentBitMap
import com.fireapp.andrewlau.myapplication.ImageList.currentImageObject
import com.fireapp.andrewlau.myapplication.ImageList.imageList
import com.fireapp.andrewlau.myapplication.Utils.Companion.getBitmapFromURL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_swatch.*
import java.net.URL
import java.util.Random


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class GenerateFragment : Fragment() {
    private val CAMERA_PIC_REQUEST = 1337
    val unsplashApiLink = "https://api.unsplash.com/photos/random?client_id=bc37901814227d25f99ac03155e0e111c458e496b2d2bd6a14dab630e5568247&count=30"
    private var mCurrentAnimator: Animator? = null
    private var mShortAnimationDuration: Int = 0
    private var expandedImageView : ImageView? = null
    var isImageFitToScreen: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_swatch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val getImage = getView()!!.findViewById(R.id.NextImage) as Button
        val imageDisplay = getView()!!.findViewById(R.id.imageDisplay) as ImageView

        if (ImageList.currentImageObject != null){
            updateImage(ImageList.currentImageObject!!)
        }

        getImage.setOnClickListener() {
            getImage()
        }

        imageDisplay.setOnClickListener(){
//            if (isImageFitToScreen) {
//                isImageFitToScreen = false
//                imageDisplay.setLayoutParams(
//                    LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.WRAP_CONTENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT
//                    )
//                )
//                imageDisplay.setAdjustViewBounds(true)
//            } else {
//                isImageFitToScreen = true
//                imageDisplay.setLayoutParams(
//                    LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT
//                    )
//                )
//                imageDisplay.setScaleType(ImageView.ScaleType.FIT_XY)
//            }
        }


    }

    private fun initializeDescText(){
        if (ImageList.currentImageObject!!.description.isNullOrEmpty()){
            ImageDesc.text = "No description available"
        } else {
            ImageDesc.text = ImageList.currentImageObject!!.description
        }
    }

    private fun getImage(){
        if (ImageList.currentImageObject != null){
            updateImage(ImageList.imageList!!.pop())
        }
        if (ImageList.imageList!!.size < 5) {
            GetImageAsyncTask().execute(unsplashApiLink)
        }
    }

    private fun updateImage(imageObj : ImageObject) {
        ImageList.currentImageObject = imageObj
        UpdateImageBitMapAsync().execute(currentImageObject?.urls?.full)
        Picasso.get()
            .load(imageObj.urls?.full)
            .fit()
            .into(imageDisplay)
        initializeDescText()

        createPaletteAsync(currentBitMap!!)
    }

    private fun createPaletteAsync(bitmap: Bitmap) {

        Palette.from(bitmap).generate { palette ->
            val defaultValue = 0x000000
            val vibrant = palette!!.getVibrantColor(defaultValue)
            val vibrantLight = palette.getLightVibrantColor(defaultValue)
            val vibrantDark = palette.getDarkVibrantColor(defaultValue)
            val muted = palette.getMutedColor(defaultValue)
            val mutedLight = palette.getLightMutedColor(defaultValue)
            val mutedDark = palette.getDarkMutedColor(defaultValue)

            vibrantView.setBackgroundColor(vibrant)
            vibrantLightView.setBackgroundColor(vibrantLight)
            vibrantDarkView.setBackgroundColor(vibrantDark)
            mutedView.setBackgroundColor(muted)
            mutedLightView.setBackgroundColor(mutedLight)
            mutedDarkView.setBackgroundColor(mutedDark)
        }
    }
}
