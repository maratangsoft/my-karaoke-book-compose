package com.maratangsoft.mykaraokebookcompose.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.maratangsoft.mykaraokebookcompose.FAVORITE
import com.maratangsoft.mykaraokebookcompose.NEW_SONG
import com.maratangsoft.mykaraokebookcompose.POPULAR
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.SEARCH

sealed class BottomNavItem(
    val title: Int,
    val icon: ImageVector,
    val screenRoute: String
) {
    object Favorite: BottomNavItem(
        R.string.bab_favorite,
        Icons.Filled.Favorite,
        FAVORITE
    )
    object Search: BottomNavItem(
        R.string.bab_search,
        Icons.Filled.Search,
        SEARCH
    )
    object NewSong: BottomNavItem(
        R.string.bab_new_song,
        Icons.Filled.Notifications,
        NEW_SONG
    )
    object Popular: BottomNavItem(
        R.string.bab_popular,
        Icons.Filled.Star,
        POPULAR
    )
}
