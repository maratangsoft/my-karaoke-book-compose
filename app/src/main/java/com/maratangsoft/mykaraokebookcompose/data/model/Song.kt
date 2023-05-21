package com.maratangsoft.mykaraokebookcompose.data.model

data class Song(
    val brand: String,
    val no: String,
    val title: String,
    val singer: String,
    val release: String = "",
    var memo: String = "",
)