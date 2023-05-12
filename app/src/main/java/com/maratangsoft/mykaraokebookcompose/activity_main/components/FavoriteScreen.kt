package com.maratangsoft.mykaraokebookcompose.activity_main.components

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.activity_setting.SettingActivity
import com.maratangsoft.mykaraokebookcompose.model.Song
import com.maratangsoft.mykaraokebookcompose.repos.TjRepository

val topBarSize = 36.dp

@Composable
fun FavoriteScreen(){
    val songs = remember { TjRepository().songs }
    ScreenLayout(
        songs = songs,
        topBar = { FavoriteTopBar() },
        recyclerView = { FavoriteRecyclerView(items = songs) }
    )
}

@Composable
fun ScreenLayout(
    songs: List<Song>,
    topBar: @Composable () -> Unit,
    recyclerView: @Composable (List<Song>) -> Unit
){
    Column(
        Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        topBar()
        Spacer(modifier = Modifier.height(16.dp))
        recyclerView(songs)
    }
}

@Composable
fun FavoriteTopBar(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        SortButton()
        Spacer(modifier = Modifier.width(4.dp))
        SettingButton()
    }
}

@Composable
fun FavoriteRecyclerView(items: List<Song>){
    LazyColumn {
        items(
            items = items,
            itemContent = { FavoriteItem(it) }
        )
    }
}

@Composable
fun SettingButton() {
    val context = LocalContext.current

    IconButton(
        modifier = Modifier.size(topBarSize),
        onClick = {
            val intent = Intent(context, SettingActivity::class.java)
            context.startActivity(intent)
        },
        content = {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = stringResource(R.string.ic_setting),
                modifier = Modifier.fillMaxSize()
            )
        }
    )
}

@Composable
fun SortButton() {
    var isExpanded by remember { mutableStateOf(false) }

    Column {
        IconButton(
            modifier = Modifier.size(topBarSize),
            onClick = { isExpanded = true }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_sort),
                contentDescription = stringResource(R.string.ic_sort),
                modifier = Modifier.fillMaxSize()
            )
        }
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(stringResource(R.string.favorite_dropdown_no)) },
                onClick = { isExpanded = false }
            )
            DropdownMenuItem(
                text = { Text(stringResource(R.string.favorite_dropdown_title)) },
                onClick = { isExpanded = false }
            )
            DropdownMenuItem(
                text = { Text(stringResource(R.string.favorite_dropdown_singer)) },
                onClick = { isExpanded = false }
            )
        }
    }
}

@Preview
@Composable
fun FavoriteScreenPreview(){
    FavoriteScreen()
}

