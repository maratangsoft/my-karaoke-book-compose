package com.maratangsoft.mykaraokebookcompose.data.network

import com.maratangsoft.mykaraokebookcompose.Language
import com.maratangsoft.mykaraokebookcompose.data.model.PopularSong
import com.maratangsoft.mykaraokebookcompose.data.model.Song

class TjDataSource {
    //TODO: use Jsoup

    val songs = listOf(
        Song("ky", "11111", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO),
        Song("ky", "22222", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO),
        Song("ky", "33333", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO),
        Song("ky", "44444", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO),
        Song("ky", "55555", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO),
    )

    val popularSongs = listOf(
        PopularSong("ky", "11111", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO, 1),
        PopularSong("ky", "22222", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO, 2),
        PopularSong("ky", "33333", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO, 3),
        PopularSong("ky", "44444", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO, 4),
        PopularSong("ky", "55555", "Into the Unknown(Frozen2(겨울왕국2) OST)", "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))", "2022-10-11", Language.KO, 5),
    )
}