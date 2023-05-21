package com.maratangsoft.mykaraokebookcompose.main.favorites

import androidx.lifecycle.ViewModel
import com.maratangsoft.mykaraokebookcompose.Brand
import com.maratangsoft.mykaraokebookcompose.SortType
import com.maratangsoft.mykaraokebookcompose.data.local_db.FavoritesRepository
import com.maratangsoft.mykaraokebookcompose.data.model.FavoriteSong
import com.maratangsoft.mykaraokebookcompose.main.FavoritesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//@HiltViewModel
class FavoritesViewModel constructor(
    private val repository: FavoritesRepository
): ViewModel() {
    var sortType = SortType.FAVORITED_DESC
    var brand = Brand.TJ

    private val _uiState: MutableStateFlow<FavoritesUiState> =
        MutableStateFlow(
            FavoritesUiState.Success(
                songs = sortSongs(repository.getFavorites(brand)),
                sortType = sortType
            )
        )
    val uiState = _uiState.asStateFlow()

    private fun sortSongs(list: List<FavoriteSong>): List<FavoriteSong> =
        when (sortType) {
            SortType.FAVORITED_DESC ->
                list.sortedBy { it.order }
            SortType.TITLE_ASC ->
                list.sortedBy { it.order }
            SortType.NUMBER_ASC ->
                list.sortedBy { it.order }
            SortType.SINGER_ASC ->
                list.sortedBy { it.order }
        }

    fun sort(sortType: SortType){
        this.sortType = sortType
    }

    fun delete(song: FavoriteSong){

    }

    fun setDialogData(song: FavoriteSong) {
        _uiState.update { currentState ->
            (currentState as FavoritesUiState.Success).copy(
                dialogData = song
            )
        }
    }
}