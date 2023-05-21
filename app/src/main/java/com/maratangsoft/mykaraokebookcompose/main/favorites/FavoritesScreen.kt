package com.maratangsoft.mykaraokebookcompose.main.favorites

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.SortType
import com.maratangsoft.mykaraokebookcompose.data.model.FavoriteSong
import com.maratangsoft.mykaraokebookcompose.main.FavoritesUiState
import com.maratangsoft.mykaraokebookcompose.main.LoadingWheel

val topBarSize = 36.dp

@Composable
fun FavoriteScreen(
    viewModel: FavoritesViewModel
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var dialogIsShown by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        FavoriteTopBar(viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        if (uiState is FavoritesUiState.Success) {
            FavoriteLazyColumn(
                songs = (uiState as FavoritesUiState.Success).songs,
                onClickItem = { song ->
                    dialogIsShown = true
                    viewModel.setDialogData(song)
                }
            )
        }
        else {
            LoadingWheel()
        }
    }
    if (dialogIsShown) {
        FavoritesDialog(
            song = (uiState as FavoritesUiState.Success).dialogData,
            onDismissRequest = { dialogIsShown = false }
        )
    }
}

@Composable
fun FavoriteTopBar(
    viewModel: FavoritesViewModel
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        SortButton(viewModel)
        Spacer(modifier = Modifier.width(40.dp))
    }
}

@Composable
fun FavoriteLazyColumn(
    songs: List<FavoriteSong>,
    onClickItem: (FavoriteSong) -> Unit
) {
    LazyColumn {
        items(
            items = songs,
            itemContent = { song ->
                FavoriteItem(
                    song = song,
                    onClick = onClickItem
                )
            }
        )
    }
}

@Composable
fun FavoritesDialog(
    song: FavoriteSong,
    onDismissRequest: () -> Unit
){
    Dialog(onDismissRequest = onDismissRequest) {

    }
}

@Composable
fun SortButton(
    viewModel: FavoritesViewModel
) {
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
            SortType.values().forEach { sortType ->
                DropdownMenuItem(
                    text = { Text(stringResource(sortType.text)) },
                    onClick = {
                        isExpanded = false
                        viewModel.sort(sortType)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun FavoriteScreenPreview(){
    FavoriteScreen(viewModel())
}

