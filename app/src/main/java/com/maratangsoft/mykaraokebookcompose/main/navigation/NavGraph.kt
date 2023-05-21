package com.maratangsoft.mykaraokebookcompose.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maratangsoft.mykaraokebookcompose.di.Injection
import com.maratangsoft.mykaraokebookcompose.main.favorites.FavoriteScreen
import com.maratangsoft.mykaraokebookcompose.main.favorites.FavoritesViewModel
import com.maratangsoft.mykaraokebookcompose.main.new_song.NewSongScreen
import com.maratangsoft.mykaraokebookcompose.main.new_song.NewSongViewModel
import com.maratangsoft.mykaraokebookcompose.main.popular.PopularScreen
import com.maratangsoft.mykaraokebookcompose.main.popular.PopularViewModel
import com.maratangsoft.mykaraokebookcompose.main.search.SearchScreen
import com.maratangsoft.mykaraokebookcompose.main.search.SearchViewModel

@Composable
fun NavGraph(navController: NavHostController){
//    val favoritesViewModel = hiltViewModel<FavoritesViewModel>()
//    val searchViewModel = hiltViewModel<SearchViewModel>()
//    val newSongViewModel = hiltViewModel<NewSongViewModel>()
//    val popularViewModel = hiltViewModel<PopularViewModel>()

    val factory = Injection.provideViewModelFactory()
    val favoritesViewModel = factory.create(FavoritesViewModel::class.java)
    val searchViewModel = factory.create(SearchViewModel::class.java)
    val newSongViewModel = factory.create(NewSongViewModel::class.java)
    val popularViewModel = factory.create(PopularViewModel::class.java)

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Favorite.screenRoute
    ) {
        composable(BottomNavItem.Favorite.screenRoute) {
            FavoriteScreen(favoritesViewModel)
        }
        composable(BottomNavItem.Search.screenRoute) {
            SearchScreen(searchViewModel)
        }
        composable(BottomNavItem.NewSong.screenRoute) {
            NewSongScreen(newSongViewModel)
        }
        composable(BottomNavItem.Popular.screenRoute) {
            PopularScreen(popularViewModel)
        }
    }
}