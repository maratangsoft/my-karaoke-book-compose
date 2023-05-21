package com.maratangsoft.mykaraokebookcompose.features.popular

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class PopularViewModel constructor(
//    private val songsRepo: SongsRepository,
) : ViewModel() {
    private val _uiState: MutableStateFlow<PopularUiState> =
        MutableStateFlow(
            PopularUiState.Loading
        )
    val uiState = _uiState.asStateFlow()

    fun fetchPopulars(){

    }

    fun changeLanguage(){

    }

    fun onClickItem(){

    }

    fun onClickAddFavorite(){

    }
}