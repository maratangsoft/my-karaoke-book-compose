package com.maratangsoft.mykaraokebookcompose.settings

import androidx.lifecycle.ViewModel
import com.maratangsoft.mykaraokebookcompose.Brand
import com.maratangsoft.mykaraokebookcompose.data.preferences.PreferencesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class SettingsViewModel constructor(
    private val repository: PreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        SettingsUiState(
            Brand.TJ
        )
    )
    val uiState = _uiState.asStateFlow()

    fun changeBrand(brand: Brand){

    }

    fun resetFavorites(){

    }

    fun exportFavorites(){

    }

    fun importFavorites(){

    }
}