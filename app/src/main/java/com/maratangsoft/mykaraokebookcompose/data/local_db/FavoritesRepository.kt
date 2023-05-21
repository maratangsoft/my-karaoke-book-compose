package com.maratangsoft.mykaraokebookcompose.data.local_db

import com.maratangsoft.mykaraokebookcompose.Brand
import com.maratangsoft.mykaraokebookcompose.data.model.FavoriteSong

class FavoritesRepository constructor(
    private val dataSource: RoomDataSource
) {
    fun addFavorite(song: FavoriteSong) {
        dataSource.insert(song)
    }

    fun getFavorites(brand: Brand): List<FavoriteSong> {
        return dataSource.select()
    }
}