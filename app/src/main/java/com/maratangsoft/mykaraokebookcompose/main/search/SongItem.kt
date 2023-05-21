package com.maratangsoft.mykaraokebookcompose.main.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maratangsoft.mykaraokebookcompose.Language
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.data.model.Song

@Composable
fun SongItem(
    song: Song,
    onClick: (Song) -> Unit
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
                ItemText14(text = song.singer)
            }
            AddFavoriteButton() {

            }
        }
    }
}

@Composable
fun ItemLayout(content: @Composable (RowScope) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp)
            .padding(4.dp, 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content(this)
    }
}

@Composable
fun ItemText18(
    text: String,
) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun ItemText16(
    text: String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        fontSize = 16.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        modifier = modifier
    )
}

@Composable
fun ItemText14(
    text: String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        fontSize = 14.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        modifier = modifier
    )
}

@Composable
fun AddFavoriteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .width(32.dp)
            .height(32.dp),
        onClick = onClick,
    ) {
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            contentDescription = stringResource(R.string.ic_add_favorite),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun SearchItemPreview(){
    val previewSong = Song(
        "tj",
        "11111",
        "Into the Unknown(Frozen2(겨울왕국2) OST)",
        "빅나티(서동현),릴러말즈(Prod.빅나티(서동현))",
        "2021-01-21",
        Language.KO
    )
    SongItem(previewSong) {}
}