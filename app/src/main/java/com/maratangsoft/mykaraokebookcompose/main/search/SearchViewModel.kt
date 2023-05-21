package com.maratangsoft.mykaraokebookcompose.main.search

import androidx.lifecycle.ViewModel
import com.maratangsoft.mykaraokebookcompose.SearchType
import com.maratangsoft.mykaraokebookcompose.data.model.Song
import com.maratangsoft.mykaraokebookcompose.data.network.SongsRepository
import com.maratangsoft.mykaraokebookcompose.main.SearchUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class SearchViewModel constructor(
    private val repository: SongsRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<SearchUiState> =
        MutableStateFlow(
            SearchUiState.Success(
                emptyList(),
                SearchType.TITLE
            )
        )
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun search(searchType: SearchType){

    }

    fun setDialogData(song: Song){

    }

    fun onClickAddFavorite(){

    }
}