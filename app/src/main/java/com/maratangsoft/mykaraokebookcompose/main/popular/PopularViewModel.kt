package com.maratangsoft.mykaraokebookcompose.main.popular

import androidx.lifecycle.ViewModel
import com.maratangsoft.mykaraokebookcompose.Language
import com.maratangsoft.mykaraokebookcompose.data.model.PopularSong
import com.maratangsoft.mykaraokebookcompose.data.network.SongsRepository
import com.maratangsoft.mykaraokebookcompose.main.PopularUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class PopularViewModel constructor(
    private val repository: SongsRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<PopularUiState> =
        MutableStateFlow(
            PopularUiState.Loading
        )
    val uiState = _uiState.asStateFlow()

    fun fetchPopulars(language: Language){

    }

    fun setDialogData(song: PopularSong){

    }

    fun onClickAddFavorite(){

    }
}