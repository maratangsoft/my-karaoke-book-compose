package com.maratangsoft.mykaraokebookcompose.features.search

import androidx.lifecycle.ViewModel
import com.maratangsoft.mykaraokebookcompose.SearchType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class SearchViewModel constructor(
//    private val songsRepo: SongsRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<SearchUiState> =
        MutableStateFlow(
            SearchUiState.Success(
                emptyList(),
                SearchType.TITLE
            )
        )
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun search(){

    }

    fun changeQuery(){

    }

    fun onClickItem(){

    }

    fun onClickAddFavorite(){

    }
}