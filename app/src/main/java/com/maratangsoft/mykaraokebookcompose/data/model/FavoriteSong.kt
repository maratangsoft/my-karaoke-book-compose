package com.maratangsoft.mykaraokebookcompose.data.model

import com.maratangsoft.mykaraokebookcompose.Language

data class FavoriteSong(
    val order: Int,
    val brand: String,
    val id: String,
    val title: String,
    val singer: String,
    val release: String,
    val language: Language,
    var memo: String = "",
)
