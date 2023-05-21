package com.maratangsoft.mykaraokebookcompose.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maratangsoft.mykaraokebookcompose.features.favorites.FavoriteScreen
import com.maratangsoft.mykaraokebookcompose.features.new_song.NewSongScreen
import com.maratangsoft.mykaraokebookcompose.features.popular.PopularScreen
import com.maratangsoft.mykaraokebookcompose.features.search.SearchScreen

@Composable
fun NavGraph(navController: NavHostController){
//    val favoritesViewModel = hiltViewModel<FavoritesViewModel>()
//    val searchViewModel = hiltViewModel<SearchViewModel>()
//    val newSongViewModel = hiltViewModel<NewSongViewModel>()
//    val popularViewModel = hiltViewModel<PopularViewModel>()

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Favorite.screenRoute
    ) {
        composable(BottomNavItem.Favorite.screenRoute) {
            FavoriteScreen()
        }
        composable(BottomNavItem.Search.screenRoute) {
            SearchScreen()
        }
        composable(BottomNavItem.NewSong.screenRoute) {
            NewSongScreen()
        }
        composable(BottomNavItem.Popular.screenRoute) {
            PopularScreen()
        }
    }
}