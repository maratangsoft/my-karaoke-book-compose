package com.maratangsoft.mykaraokebookcompose.features.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.SortType
import com.maratangsoft.mykaraokebookcompose.data.model.Song
import com.maratangsoft.mykaraokebookcompose.main.LoadingWheel
import com.maratangsoft.mykaraokebookcompose.main.ScreenLayout

val topBarSize = 36.dp

@Composable
fun FavoriteScreen(
    viewModel: FavoritesViewModel = viewModel()
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ScreenLayout(
        topBar = { FavoriteTopBar() },
        recyclerView = {
            when (uiState) {
                FavoritesUiState.Loading ->
                    LoadingWheel()
                is FavoritesUiState.Success ->
                    FavoriteRecyclerView(
                        items = (uiState as FavoritesUiState.Success).favorites
                    )
            }
        }
    )
}

@Composable
fun FavoriteTopBar(
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        SortButton()
        Spacer(modifier = Modifier.width(40.dp))
    }
}

@Composable
fun FavoriteRecyclerView(items: List<Song>){
    LazyColumn {
        items(
            items = items,
            itemContent = { FavoriteItem(it) },
        )
    }
}

@Composable
fun SortButton(
    viewModel: FavoritesViewModel = viewModel()
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
    FavoriteScreen()
}

