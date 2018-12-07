package com.fireapp.andrewlau.myapplication

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lab4_masterdetailflow.dummy.ALauDatastore
import com.squareup.picasso.Picasso
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import android.R.string.cancel
import android.content.DialogInterface
import kotlinx.android.synthetic.main.color_swatch_frag.*


class ColorSwatchFrag : DialogFragment() {
    private val CAMERA_REQUEST = 1888
    private var color : Int? = null
    private var colorText : String? = ""


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.color_swatch_frag, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null){

            color = arguments!!.getInt("color")
            colorText = arguments!!.getString("colorText")
            setColor(color!!, colorText!!)
        }
    }

    private fun setColor(color : Int, colorText : String){
        ColorView.setBackgroundColor(color)
        ColorView.text = colorText
    }

}
