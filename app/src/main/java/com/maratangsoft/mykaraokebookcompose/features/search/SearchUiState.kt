package com.maratangsoft.mykaraokebookcompose.features.search

import com.maratangsoft.mykaraokebookcompose.SearchType
import com.maratangsoft.mykaraokebookcompose.data.model.Song

sealed interface SearchUiState {
    data class Success(
        val songs: List<Song>,
        val searchType: SearchType
    ) : SearchUiState
    object Loading : SearchUiState
}