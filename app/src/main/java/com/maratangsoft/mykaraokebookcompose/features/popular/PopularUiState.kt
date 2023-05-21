package com.maratangsoft.mykaraokebookcompose.features.popular

import com.maratangsoft.mykaraokebookcompose.Language
import com.maratangsoft.mykaraokebookcompose.data.model.Song

sealed interface PopularUiState {
    data class Success(
        val populars: List<Song>,
        val language: Language
    ) : PopularUiState
    object Loading : PopularUiState
}