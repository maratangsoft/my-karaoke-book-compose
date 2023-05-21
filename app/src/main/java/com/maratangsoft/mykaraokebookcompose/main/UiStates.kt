package com.maratangsoft.mykaraokebookcompose.main

import com.maratangsoft.mykaraokebookcompose.Language
import com.maratangsoft.mykaraokebookcompose.MonthType
import com.maratangsoft.mykaraokebookcompose.SearchType
import com.maratangsoft.mykaraokebookcompose.SortType
import com.maratangsoft.mykaraokebookcompose.data.model.FavoriteSong
import com.maratangsoft.mykaraokebookcompose.data.model.PopularSong
import com.maratangsoft.mykaraokebookcompose.data.model.Song

sealed interface MainUiState {
    data class Success(
        val songs: List<Song>
    ) : MainUiState
    object Loading: MainUiState
}

sealed interface FavoritesUiState : MainUiState {
    data class Success(
        val songs: List<FavoriteSong> = emptyList(),
        val sortType: SortType = SortType.FAVORITED_DESC,
        val dialogData: FavoriteSong = FavoriteSong(1, "init", "init", "init", "init", "init", Language.KO),
    ) : FavoritesUiState
    object Loading : FavoritesUiState
}

sealed interface SearchUiState : MainUiState {
    data class Success(
        val songs: List<Song> = emptyList(),
        val searchType: SearchType = SearchType.TITLE
    ) : SearchUiState
    object Loading : SearchUiState
}

sealed interface NewSongUiState : MainUiState {
    data class Success(
        val songs: List<Song> = emptyList(),
        val monthType: MonthType = MonthType.THIS_MONTH
    ) : NewSongUiState
    object Loading : NewSongUiState
}

sealed interface PopularUiState : MainUiState {
    data class Success(
        val songs: List<PopularSong> = emptyList(),
        val language: Language = Language.KO
    ) : PopularUiState
    object Loading : PopularUiState
}