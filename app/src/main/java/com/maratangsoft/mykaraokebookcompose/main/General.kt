package com.maratangsoft.mykaraokebookcompose.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maratangsoft.mykaraokebookcompose.data.model.Song
import com.maratangsoft.mykaraokebookcompose.features.search.SearchItem

@Composable
fun ScreenLayout(
    topBar: @Composable () -> Unit,
    recyclerView: @Composable () -> Unit
){
    Column(
        Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        topBar()
        Spacer(modifier = Modifier.height(16.dp))
        recyclerView.invoke()
    }
}

@Composable
fun LoadingWheel() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Now Loading...")
    }
}

@Composable
fun CommonRecyclerView(items: List<Song>){
    LazyColumn{
        items(
            items = items,
            itemContent = { SearchItem(it) }
        )
    }
}