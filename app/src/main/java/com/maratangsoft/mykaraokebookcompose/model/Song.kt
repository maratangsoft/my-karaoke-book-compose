package com.maratangsoft.mykaraokebookcompose.model

data class Song(
    val brand: String,
    val no: String,
    val title: String,
    val singer: String,
    val release: String = "",
    val memo: String = ""
)
