package com.fireapp.andrewlau.myapplication


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.graphics.*
import android.support.v7.graphics.Palette
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_swatch.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment3 : Fragment() {
    private val CAMERA_PIC_REQUEST = 1337
    val unsplashApiLink = "https://api.unsplash.com/photos/random?client_id=bc37901814227d25f99ac03155e0e111c458e496b2d2bd6a14dab630e5568247&count=30"
//    var currentImageUrl : String? = ""
//    var currentImageBitmap : Bitmap? = null
//    var currentImageDesc : String? = ""

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
        GetImageAsyncTask(::updateInfo).execute(unsplashApiLink)

        getImage.setOnClickListener() {
            if (ImageList.imageList.size < 3){
                GetImageAsyncTask(::updateInfo).execute(unsplashApiLink)
            } else {
                UpdateImageAsyncTask(::updateInfo).execute()
            }
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

    private fun initializeDescText(imageDesc : String){
        ImageDesc.text = imageDesc
    }


    private fun updateInfo(imageUrl : String, imageDesc : String, imageBitmap : Bitmap) {
        Picasso.get()
            .load(imageUrl)
            .fit()
            .into(imageDisplay)
        initializeDescText(imageDesc)
        createPalette(imageBitmap)
    }

    private fun createPalette(bitmap: Bitmap) {

        Palette.from(bitmap).generate { palette ->
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
            vibrantLightView.setBackgroundColor(c2)
            vibrantDarkView.setBackgroundColor(c3)
            mutedView.setBackgroundColor(c4)
            mutedLightView.setBackgroundColor(c5)
            mutedDarkView.setBackgroundColor(c6)
            mutedView2.setBackgroundColor(c7)
            mutedLightView2.setBackgroundColor(c8)
            mutedDarkView2.setBackgroundColor(c9)
        }
    }
}
