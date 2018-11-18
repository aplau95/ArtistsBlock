package com.fireapp.andrewlau.myapplication


data class Word (
    val word : String? = "",
    val id : String? = ""
)

data class Metadata (
    val offset : Int? = null,
    val limit : Int? = null,
    val provider : String? = "",
    val total : Int? = null,
    val sourceLanguage : String? = ""
)

data class CompleteJson(val metadata : Metadata, val results : List<Word>) {
    fun generateWords(): String {
        currentWord.WORD = results[0].word!!
        return currentWord.WORD
    }
}

data class Value (
    val url : String? = "",
    val height : Int? = null,
    val width : Int? = null,
    val thumbnail : String? = "",
    val thumbnailHeight : Int? = null,
    val thumbnailWidth : Int? = null,
    val base64Encoding : String? = ""
)

data class ImageJson(val _type : String, val value : List<Value>) {
    fun generateImageUrl(): String {
        return value[0].url!!
    }
}

data class DefinitionJson(val metadata : Metadata, val defResults : DefinitionResults) {
    fun generateDefinition(): String {
        return defResults.lexicalEntries!![0].entries!![0].senses!![0].definitions!![0]
    }
}

data class Example (
    val text : String? = ""
)

data class Sense (
    val definitions : List<String>? = null,
    val domains : List<String>? = null,
    val examples : List<Example>? = null,
    val id : String? = null,
    val short_definitions : List<String>? = null
)

data class GrammaticalFeatures (
    val text : String? = "",
    val type : String? = ""
)

data class VariantForm (
    val text : String? = ""
)

data class Entry (
    val etymologies: List<String>? = null,
    val grammaticalFeatures: GrammaticalFeatures? = null,
    val homographNumber: Int? = null,
    val senses: List<Sense>? = null,
    val variantForms: List<VariantForm>? = null
)

data class LexicalEntry (
    val entries : List<Entry>? = null,
    val language : String? = "",
    val lexicalCategory : String? = "",
    val text : String? = ""
)

data class DefinitionResults (
    val id : String? = "",
    val language : String? = "",
    val lexicalEntries : List<LexicalEntry>? = null,
    val type : String? = "",
    val word : String? = ""
)

object currentWord {
    var WORD: String = ""
    var IMAGEURL : String = ""
    var DEFINITION : String = ""
}





