package com.maratangsoft.mykaraokebookcompose.activity_main.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maratangsoft.mykaraokebookcompose.activity_main.components.FavoriteScreen
import com.maratangsoft.mykaraokebookcompose.activity_main.components.NewSongScreen
import com.maratangsoft.mykaraokebookcompose.activity_main.components.PopularScreen
import com.maratangsoft.mykaraokebookcompose.activity_main.components.SearchScreen

@Composable
fun NavGraph(navController: NavHostController){

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