package com.maratangsoft.mykaraokebookcompose.features.new_song

import com.maratangsoft.mykaraokebookcompose.MonthType
import com.maratangsoft.mykaraokebookcompose.data.model.Song

sealed interface NewSongUiState {
    data class Success(
        val newSongs: List<Song>,
        val monthType: MonthType
    ) : NewSongUiState
    object Loading : NewSongUiState
}