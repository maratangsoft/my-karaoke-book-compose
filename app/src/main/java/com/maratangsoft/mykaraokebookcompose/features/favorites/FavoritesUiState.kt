package com.maratangsoft.mykaraokebookcompose.features.favorites

import com.maratangsoft.mykaraokebookcompose.SortType
import com.maratangsoft.mykaraokebookcompose.data.model.Song

sealed interface FavoritesUiState {
    data class Success(
        val favorites: List<Song>,
        val sortType: SortType
    ) : FavoritesUiState
    object Loading : FavoritesUiState
}