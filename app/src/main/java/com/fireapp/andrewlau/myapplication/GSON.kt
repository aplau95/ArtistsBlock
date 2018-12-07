package com.fireapp.andrewlau.myapplication

import android.graphics.Bitmap
import java.util.*

data class Position (
    val latitude : Float? = null,
    val longitude : Float? = null
)

data class Location (
    val title : String? = "",
    val name : String? = "",
    val city : String? = "",
    val country : String? = "",
    val position : Position? = null
)

data class CollectionInstance (
    val id : Int? = null,
    val title : String? = "",
    val published_at : String? = "",
    val updated_at: String? = "",
    val curated : Boolean? = null,
    val cover_photo : String? = "",
    val user : String? = ""

)

data class Links (
    val self : String? = "",
    val html : String? = "",
    val download : String? = "",
    val download_location : String? = ""
)

data class Urls (
    val raw : String? = "",
    val full : String? = "",
    val regular : String? = "",
    val small : String? = "",
    val thumb : String? = ""
)

data class ImageObject (
    val id : String? = "",
    val created_at : String? = "",
    val updated_at : String? = "",
    val width : Int? = null,
    val height : Int? = null,
    val color : String? = "",
    val description : String? = null,
    val urls : Urls? = null,
    val links : Links? = null,
    val categories : Array<String>? = null,
    val sponsored : Boolean? = null,
    val sponsored_by : String? = null,
    val sponsored_impression_id : String? = null,
    val likes: Int? = null,
    val liked_by_user : Boolean? = null,
    val current_user_collections : List<CollectionInstance>? = null,
    val slug : String? = null,
    val user : User? = null,
    val exif : Exif? = null,
    val location : Location? = null,
    val views : Int? = null,
    val downloads : Int? = null
)

data class User (
    val id : String? = "",
    val updated_at: String? = "",
    val username : String? = "",
    val name : String? = "",
    val first_name : String? = "",
    val last_name : String? = "",
    val twitter_username : String? = "",
    val portfolio_url : String? = "",
    val bio : String? = "",
    val location : String? = "",
    val links : Links2? = null,
    val profile_image : ProfileImage? = null,
    val instagram_username : String? = "",
    val total_collections : Int? = null,
    val total_likes : Int? = null,
    val total_photos : Int? = null,
    val accepted_tos : Boolean? = null
)

data class Links2 (
    val self : String? = "",
    val html : String? = "",
    val photos : String? = "",
    val likes : String? = "",
    val portfolio : String? = "",
    val following : String? = "",
    val followers : String? = ""
)


data class Exif (
    val make : String? = "",
    val model : String? = "",
    val exposureTime : String? = "",
    val aperture : String? = "",
    val focal_length : String? = "",
    val iso : Int? = null
)

data class ProfileImage (
    val small : String? = "",
    val medium : String? = "",
    val large : String? = ""
)

object ImageList {
    var imageList : Stack<ImageObject> = Stack()
    var currentImage : String? = null
    var currentImageDesc : String? = null
    var currentImageObject : ImageObject? = null
    var currentBitMap : Bitmap? = null
}



