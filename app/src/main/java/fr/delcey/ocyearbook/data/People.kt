package fr.delcey.ocyearbook.data

data class People(
    var id: Int,
    var photo: Int,
    var name: String,
    var function: String,
    var firstLanguage: String,
    var secondLanguage: String? = null,
    var sentence: Int
)