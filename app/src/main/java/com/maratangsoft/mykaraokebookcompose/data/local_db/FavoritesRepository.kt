package com.maratangsoft.mykaraokebookcompose.data.local_db

import com.maratangsoft.mykaraokebookcompose.Brand
import com.maratangsoft.mykaraokebookcompose.SortType
import com.maratangsoft.mykaraokebookcompose.data.model.Song

class FavoritesRepository constructor(
    private val room: RoomDataSource
) {
    fun addFavorite(song: Song) {
        room.insert(song)
    }

    fun getFavorites(
        brand: Brand,
        sortType: SortType
    ): List<Song> {
        return room.select()
    }
}