package com.maratangsoft.mykaraokebookcompose.features.new_song

import androidx.lifecycle.ViewModel
import com.maratangsoft.mykaraokebookcompose.MonthType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class NewSongViewModel constructor(
//    private val songsRepo: SongsRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<NewSongUiState> =
        MutableStateFlow(
            NewSongUiState.Loading
        )
    val uiState = _uiState.asStateFlow()

    fun fetchNewSongs(){

    }

    fun changeMonth(monthType: MonthType){

    }

    fun onClickItem(){

    }

    fun onClickAddFavorite(){

    }
}