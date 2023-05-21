package com.maratangsoft.mykaraokebookcompose.data.network

import com.maratangsoft.mykaraokebookcompose.Brand
import com.maratangsoft.mykaraokebookcompose.Language
import com.maratangsoft.mykaraokebookcompose.SearchType
import com.maratangsoft.mykaraokebookcompose.data.model.Song

class SongsRepository constructor(
    private val tj: TjDataSource,
    private val ky: KyDataSource
) {
    fun searchSongs(
        brand: Brand,
        searchType: SearchType,
        query: String
    ): List<Song> {
        return when (brand) {
            Brand.TJ -> tj.songs
            Brand.KY -> ky.songs
        }
    }

    fun getNewSongs(
        brand: Brand,
        month: String
    ): List<Song> {
        return when (brand) {
            Brand.TJ -> tj.songs
            Brand.KY -> ky.songs
        }
    }

    fun getPopularSongs(
        brand: Brand,
        language: Language
    ): List<Song> {
        return when (brand) {
            Brand.TJ -> tj.songs
            Brand.KY -> ky.songs
        }
    }
}