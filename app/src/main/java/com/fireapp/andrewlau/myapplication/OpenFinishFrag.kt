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
import kotlinx.android.synthetic.main.finish_dialog_frag.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import android.R.string.cancel
import android.content.DialogInterface



class OpenFinishFrag : DialogFragment() {
    private val CAMERA_REQUEST = 1888
    private var photoBM : Bitmap? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.finish_dialog_frag, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateInfo(ImageList.currentImage!!)

        photoDisplay.setOnClickListener { takeImageFromCamera() }

        CancelFragButton.setOnClickListener { dismiss() }

        PublishButton.setOnClickListener { publishPainting() }
    }

    private fun updateInfo(imageUrl : String) {
        Picasso.get()
            .load(imageUrl)
            .fit()
            .into(imageFragDisplay)

    }

    private fun publishPainting () {
        if (photoBM != null) {
            val currentDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)
            val newDrawItem = ALauDatastore.DrawItem(currentDate, ImageList.currentImageDesc!!, photoBM!!)
            ALauDatastore.addItem(newDrawItem)
            dismiss()
        } else {
            errorText.visibility = View.VISIBLE
        }
    }

    private fun takeImageFromCamera() {
        val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            photoBM = data!!.extras!!.get("data") as Bitmap
            photoDisplay.setImageBitmap(photoBM)
        }
    }

}
