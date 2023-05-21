package com.maratangsoft.mykaraokebookcompose.main.new_song

import androidx.lifecycle.ViewModel
import com.maratangsoft.mykaraokebookcompose.MonthType
import com.maratangsoft.mykaraokebookcompose.data.model.Song
import com.maratangsoft.mykaraokebookcompose.data.network.SongsRepository
import com.maratangsoft.mykaraokebookcompose.main.NewSongUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class NewSongViewModel constructor(
    private val repository: SongsRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<NewSongUiState> =
        MutableStateFlow(
            NewSongUiState.Loading
        )
    val uiState = _uiState.asStateFlow()

    fun fetchNewSongs(monthType: MonthType){

    }

    fun setDialogData(song: Song){

    }

    fun onClickAddFavorite(song: Song){

    }
}