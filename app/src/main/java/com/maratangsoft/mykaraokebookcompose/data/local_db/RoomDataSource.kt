package com.maratangsoft.mykaraokebookcompose.data.local_db

import com.maratangsoft.mykaraokebookcompose.Util
import com.maratangsoft.mykaraokebookcompose.data.model.Song

class RoomDataSource {

    fun initialize(){

    }

    fun insert(song: Song) {
        Util.log("insert complete: ${song.title}")
    }

    fun select(): List<Song> {
        return listOf(
            Song("ky", "11111", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", memo = "메모야아아아"),
            Song("ky", "22222", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", memo = "메모야아아아"),
            Song("ky", "33333", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", memo = "메모야아아아"),
            Song("ky", "44444", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", memo = "메모야아아아"),
            Song("ky", "55555", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", memo = "메모야아아아"),
        )
    }
}