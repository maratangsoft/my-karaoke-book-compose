package com.maratangsoft.mykaraokebookcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.maratangsoft.mykaraokebookcompose.main.navigation.BottomNavItem
import com.maratangsoft.mykaraokebookcompose.main.navigation.NavGraph
import com.maratangsoft.mykaraokebookcompose.main.theme.BrandColor
import com.maratangsoft.mykaraokebookcompose.main.theme.MainTheme
import com.maratangsoft.mykaraokebookcompose.settings.SettingsActivity

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreenView() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView (){
    MainTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomNavBar(navController) },
            content = {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopEnd
                ){
                    SettingButton()
                    NavGraph(navController = navController)
                }
            }
        )
    }
}

@Composable
fun SettingButton() {
    val context = LocalContext.current
    IconButton(
        modifier = Modifier.padding(top = 6.dp, end = 4.dp),
        onClick = {
            context.startActivity(Intent(context, SettingsActivity::class.java))
        },
        content = {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = stringResource(R.string.ic_setting),
                modifier = Modifier.fillMaxSize()
            )
        }
    )
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