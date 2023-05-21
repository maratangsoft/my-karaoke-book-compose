package com.maratangsoft.mykaraokebookcompose.features.favorites

import androidx.lifecycle.ViewModel
import com.maratangsoft.mykaraokebookcompose.SortType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class FavoritesViewModel constructor(
//    private val favoriteRepo: FavoritesRepository
): ViewModel() {

    private val _uiState: MutableStateFlow<FavoritesUiState> =
        MutableStateFlow(
            FavoritesUiState.Success(
                emptyList(),
                SortType.FAVORITED_DESC
            )
        )
    val uiState = _uiState.asStateFlow()

    fun fetchFavorites(){

    }

    fun sort(sortType: SortType){

    }

    fun onClickItem(){

    }
}