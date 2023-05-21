package com.maratangsoft.mykaraokebookcompose.main.popular

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maratangsoft.mykaraokebookcompose.Language
import com.maratangsoft.mykaraokebookcompose.data.model.PopularSong
import com.maratangsoft.mykaraokebookcompose.main.search.ItemLayout
import com.maratangsoft.mykaraokebookcompose.main.search.ItemText14
import com.maratangsoft.mykaraokebookcompose.main.search.ItemText16
import com.maratangsoft.mykaraokebookcompose.main.search.ItemText18

@Composable
fun PopularItem(
    song: PopularSong,
    onClick: (PopularSong) -> Unit
){
    ItemLayout {
        Row(modifier = Modifier.clickable { onClick.invoke(song) }) {
            ItemText18(text = song.id)
            Spacer(modifier = Modifier.padding(4.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                ItemText16(text = song.title)
                Row {
                    ItemText14(text = song.singer)
                }
            }
        }
    }
}

@Preview
@Composable
fun PopularItemPreview(){
    val previewSong = PopularSong(
        "tj",
        "11111",
        "Into the Unknown(Frozen2(겨울왕국2) OST)",
        "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))",
        "2021-01-21",
        Language.KO,
        1
    )
    PopularItem(previewSong) {}
}