package com.maratangsoft.mykaraokebookcompose.features.favorites

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
import com.maratangsoft.mykaraokebookcompose.data.model.Song
import com.maratangsoft.mykaraokebookcompose.features.search.ItemLayout
import com.maratangsoft.mykaraokebookcompose.features.search.ItemText14
import com.maratangsoft.mykaraokebookcompose.features.search.ItemText16
import com.maratangsoft.mykaraokebookcompose.features.search.ItemText18
import com.maratangsoft.mykaraokebookcompose.features.search.previewSong

@Composable
fun FavoriteItem(song: Song){
    ItemLayout {
        Row(modifier = Modifier.clickable {  }) {
            ItemText18(text = song.no)
            Spacer(modifier = Modifier.padding(4.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                ItemText16(text = song.title)
                Row {
                    ItemText14(text = song.singer)
                    ItemText14(text = song.memo, modifier = Modifier.weight(1f, false))
                }
            }
        }
    }
}

@Preview
@Composable
fun FavoriteItemPreview(){
    FavoriteItem(song = previewSong)
}