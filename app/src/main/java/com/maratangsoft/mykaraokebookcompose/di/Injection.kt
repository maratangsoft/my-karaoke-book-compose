package com.maratangsoft.mykaraokebookcompose.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maratangsoft.mykaraokebookcompose.data.local_db.FavoritesRepository
import com.maratangsoft.mykaraokebookcompose.data.local_db.RoomDataSource
import com.maratangsoft.mykaraokebookcompose.data.network.KyDataSource
import com.maratangsoft.mykaraokebookcompose.data.network.SongsRepository
import com.maratangsoft.mykaraokebookcompose.data.network.TjDataSource
import com.maratangsoft.mykaraokebookcompose.data.preferences.DataStoreDataSource
import com.maratangsoft.mykaraokebookcompose.data.preferences.PreferencesRepository
import com.maratangsoft.mykaraokebookcompose.main.favorites.FavoritesViewModel
import com.maratangsoft.mykaraokebookcompose.main.new_song.NewSongViewModel
import com.maratangsoft.mykaraokebookcompose.main.popular.PopularViewModel
import com.maratangsoft.mykaraokebookcompose.main.search.SearchViewModel
import com.maratangsoft.mykaraokebookcompose.settings.SettingsViewModel

object Injection {
    private val tjDataSource = TjDataSource()
    private val kyDataSource = KyDataSource()
    private val roomDataSource = RoomDataSource()
    private val dataStoreDataSource = DataStoreDataSource()

    val favoritesRepository = FavoritesRepository(roomDataSource)
    val songsRepository = SongsRepository(tjDataSource, kyDataSource)
    val preferencesRepository = PreferencesRepository(dataStoreDataSource)

    fun provideViewModelFactory() = ViewModelFactory.getInstance()
}

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == FavoritesViewModel::class.java) {
            return FavoritesViewModel(Injection.favoritesRepository) as T
        }
        if (modelClass == SearchViewModel::class.java) {
            return SearchViewModel(Injection.songsRepository) as T
        }
        if (modelClass == NewSongViewModel::class.java) {
            return NewSongViewModel(Injection.songsRepository) as T
        }
        if (modelClass == PopularViewModel::class.java) {
            return PopularViewModel(Injection.songsRepository) as T
        }
        if (modelClass == SettingsViewModel::class.java) {
            return SettingsViewModel(Injection.preferencesRepository) as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }

    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance() : ViewModelFactory {
            if (INSTANCE == null) {
                INSTANCE = ViewModelFactory()
            }
            return INSTANCE!!
        }
    }
}