package com.fireapp.andrewlau.myapplication

data class Word (
    val word : String? = "",
    val id : String? = ""
)

data class CompleteJson(val metadata : Metadata, val results : List<Word>) {
    fun generateWords(): String {
        currentWord.WORD = results[0].word!!
        return currentWord.WORD
    }
}

data class Metadata (
    val limit : Int? = null,
    val total : Int? = null,
    val offset : Int? = null,
    val provider : String? = "",
    val sourceLanguage : String? = ""
)

object currentWord {
    var WORD: String = ""
}


