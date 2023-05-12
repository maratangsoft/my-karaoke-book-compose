package com.maratangsoft.mykaraokebookcompose.activity_main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.maratangsoft.mykaraokebookcompose.activity_main.nav.BottomNavItem
import com.maratangsoft.mykaraokebookcompose.activity_main.nav.NavGraph
import com.maratangsoft.mykaraokebookcompose.theme.BrandColor
import com.maratangsoft.mykaraokebookcompose.theme.MainTheme

class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreenView() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView(){
    MainTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomNavBar(navController) },
            content = {
                Box(Modifier.padding(it)){
                    NavGraph(navController = navController)
                }
            }
        )
    }
}

@Composable
fun BottomNavBar(navController: NavHostController){
    val bottomNavItems = listOf(
        BottomNavItem.Favorite,
        BottomNavItem.Search,
        BottomNavItem.NewSong,
        BottomNavItem.Popular
    )
    NavigationBar(
        containerColor = BrandColor,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.screenRoute,
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = item.title)
                    )
                },
                label = { Text(stringResource(id = item.title)) },
                onClick = {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MainScreenView()
}