package com.maratangsoft.mykaraokebookcompose.data.local_db

import com.maratangsoft.mykaraokebookcompose.Language
import com.maratangsoft.mykaraokebookcompose.Util
import com.maratangsoft.mykaraokebookcompose.data.model.FavoriteSong
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RoomDataSource {

    val FavoritesData: Flow<List<FavoriteSong>> = flow {

    }

    fun initialize(){

    }

    fun insert(song: FavoriteSong) {
        Util.log("insert complete: ${song.title}")
    }

    fun select(): List<FavoriteSong> {
        return listOf(
            FavoriteSong(1, "ky", "11111", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))","2022-10-11", Language.KO, "memomemo"),
            FavoriteSong(2, "ky", "22222", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))","2022-10-11", Language.KO, "memomemo"),
            FavoriteSong(3, "ky", "33333", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))","2022-10-11", Language.KO, "memomemo"),
            FavoriteSong(4, "ky", "44444", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))","2022-10-11", Language.KO, "memomemo"),
            FavoriteSong(5, "ky", "55555", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))","2022-10-11", Language.KO, "memomemo"),
        )
    }
}