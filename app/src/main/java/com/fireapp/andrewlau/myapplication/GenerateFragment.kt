package com.fireapp.andrewlau.myapplication


import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.graphics.*
import android.net.Uri
import android.support.v7.graphics.Palette
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.lab4_masterdetailflow.dummy.ALauDatastore
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_swatch.*


//import edu.calpoly.rscovil.dialogfragments.OpenFinishFrag


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class GenerateFragment : Fragment(){
    val unsplashApiLink = "https://api.unsplash.com/photos/random?client_id=bc37901814227d25f99ac03155e0e111c458e496b2d2bd6a14dab630e5568247&count=30&orientation=landscape&featured"

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

        getNewImage()

        val completeButton = getView()!!.findViewById(R.id.CompleteButton) as Button
        completeButton.setOnClickListener {
            openFinishFragment()

        }

        getImage.setOnClickListener() {
           getNewImage()
        }

        imageDisplay.setOnClickListener() {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(ImageList.currentImage))
            startActivity(browserIntent)
        }

//        superView.setOnClickListener() {
//            superView.setBackgroundColor(0)
//            superView.isClickable = false
//            superView.visibility = View.INVISIBLE
//
//        }


    }

    private fun getNewImage() {
        if (ImageList.imageList.size < 3){
            GetImageAsyncTask(::updateInfo).execute(unsplashApiLink)
        } else {
            UpdateImageAsyncTask(::updateInfo).execute()
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
            val c1 = palette!!.swatches[0].rgb
            val c2 = palette!!.swatches[1].rgb
            val c3 = palette!!.swatches[2].rgb
            val c4 = palette!!.swatches[3].rgb
            val c5 = palette!!.swatches[4].rgb
            val c6 = palette!!.swatches[5].rgb
            val c7 = palette!!.swatches[6].rgb
            val c8 = palette!!.swatches[7].rgb
            val c9 = palette!!.swatches[8].rgb

            c1View.setBackgroundColor(c1)
            println("c1 colors are " + c1.toString())
            val c1String = String.format("#%06X", 0xFFFFFF and c1)
            c1View.text = c1String
            c1View.setOnClickListener { openColorFrag(c1,c1String) }

            c2View.setBackgroundColor(c2)
            val c2String = String.format("#%06X", 0xFFFFFF and c2)
            c2View.text = c2String
            c2View.setOnClickListener { openColorFrag(c2,c2String) }

            c3View.setBackgroundColor(c3)
            val c3String = String.format("#%06X", 0xFFFFFF and c3)
            c3View.text = c3String
            c3View.setOnClickListener { openColorFrag(c3,c3String) }

            c4View.setBackgroundColor(c4)
            val c4String = String.format("#%06X", 0xFFFFFF and c4)
            c4View.text = c4String
            c4View.setOnClickListener { openColorFrag(c4,c4String) }


            c5View.setBackgroundColor(c5)
            val c5String = String.format("#%06X", 0xFFFFFF and c5)
            c5View.text = c5String
            c5View.setOnClickListener { openColorFrag(c5,c5String) }

            c6View.setBackgroundColor(c6)
            val c6String = String.format("#%06X", 0xFFFFFF and c6)
            c6View.text = c6String
            c6View.setOnClickListener { openColorFrag(c6,c6String) }

            c7View.setBackgroundColor(c7)
            val c7String = String.format("#%06X", 0xFFFFFF and c7)
            c7View.text = c7String
            c7View.setOnClickListener { openColorFrag(c7,c7String) }

            c8View.setBackgroundColor(c8)
            val c8String = String.format("#%06X", 0xFFFFFF and c8)
            c8View.text = c8String
            c8View.setOnClickListener { openColorFrag(c8,c8String) }

            c9View.setBackgroundColor(c9)
            val c9String = String.format("#%06X", 0xFFFFFF and c9 )
            c9View.text = c9String
            c9View.setOnClickListener { openColorFrag(c9,c9String) }


        }
    }

//    private fun fillColor (color : Int){
//        superView.setBackgroundColor(color)
//        superView.isClickable = true
//    }

    private fun openColorFrag(color : Int, colorText : String) {
        val bundle = Bundle()
        bundle.putInt("color", color)
        bundle.putString("colorText", colorText)
        val dialog = ColorSwatchFrag()
        dialog.arguments = bundle
        dialog.show(fragmentManager, "ColorSwatchFragment")
    }

    private fun openFinishFragment() {
        val dialog = OpenFinishFrag()
        dialog.show(fragmentManager, "NoticeDialogFragment")
    }
}
