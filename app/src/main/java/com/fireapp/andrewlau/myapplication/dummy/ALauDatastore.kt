package com.example.lab4_masterdetailflow.dummy

import android.graphics.Bitmap
import java.io.FileDescriptor
import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object ALauDatastore {

    val ITEMS: MutableList<DrawItem> = ArrayList()


    var index = 1
    var needNewImages = true

    fun addItem(item: DrawItem) {
        ITEMS.add(item)
        index ++
    }

    data class DrawItem(val date: String, val desc : String, val imageBitMap : Bitmap) {

        override fun toString(): String {
            return "$date $desc"
        }
    }
}
