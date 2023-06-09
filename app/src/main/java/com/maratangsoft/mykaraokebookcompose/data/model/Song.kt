package com.maratangsoft.mykaraokebookcompose.data.model

import com.maratangsoft.mykaraokebookcompose.Language

data class Song(
    val brand: String,
    val id: String,
    val title: String,
    val singer: String,
    val release: String,
    val language: Language,
)