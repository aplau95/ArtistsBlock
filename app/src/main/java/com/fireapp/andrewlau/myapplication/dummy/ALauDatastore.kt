package com.example.lab4_masterdetailflow.dummy

import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object ALauDatastore {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DrawItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DrawItem> = HashMap()

    var index = 0

    fun addItem(item: DrawItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    fun createDrawItem(title: String, medium: String, action: String, definition: String): DrawItem {
        index += 1;
        return DrawItem(index.toString(), title, medium, action, definition)
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DrawItem(val id: String, val title: String, val medium: String,
                        val action: String, val definition: String) {

        override fun toString(): String {
            return "$id $title $medium $action $definition"
        }
    }
}
