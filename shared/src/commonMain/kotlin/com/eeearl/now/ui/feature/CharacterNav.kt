package com.eeearl.now.ui.feature

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.eeearl.now.ui.AppScreen
import com.eeearl.now.ui.BottomBarScreen
import com.eeearl.now.ui.component.NowTopBar

@Composable
fun CharacterNav() {
    val navController = rememberNavController()
    NavHostMain(
        navController = navController,
        onNavigate = { routeName ->
            navigateTo(routeName, navController)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavHostMain(
    navController: NavHostController = rememberNavController(),
    onNavigate: (rootName: String) -> Unit,
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination

    Scaffold(
        topBar = {
            val title = getTitle(currentScreen)
            NowTopBar(
                modifier = Modifier,
                title = title,
                canNavigateBack = currentScreen?.route != AppScreen.CharacterTop.route,
                navigateUp = { navController.navigateUp() }
            )
        },
        bottomBar = {
//            BottomNavigationBar(navController)
            BottomAppBar {

            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            enterTransition = {
                fadeIn(animationSpec = tween(500))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(500))
            },
            popEnterTransition = {
                fadeIn(animationSpec = tween(500))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(500))
            }
        ) {
            composable(route = BottomBarScreen.Home.route) {
                CharacterTopScreen(onNavigate = onNavigate)
            }
            composable(route = BottomBarScreen.Detail.route) {
                CharacterDetailScreen(onNavigate = onNavigate)
            }
//            composable(route = BottomBarScreen.Reels.route) {
//                ReelsView(onNavigate = onNavigate)
//            }
//            composable(route = BottomBarScreen.Profile.route) {
//                ProfileView(onNavigate = onNavigate)
//            }
//            composable(route = AppScreen.Detail.route) {
//                DetailsView(onNavigate = onNavigate)
//            }
        }
    }
}
fun navigateTo(
    routeName: String,
    navController: NavController
) {
    when (routeName) {
        "BackButton" -> {
            navController.popBackStack()
        }

        else -> {
            navController.navigate(routeName)
        }
    }
}
fun getTitle(currentScreen: NavDestination?): String {
    return when (currentScreen?.route) {
        BottomBarScreen.Home.route -> {
            "Home"
        }

        BottomBarScreen.Reels.route -> {
            "Reels"
        }

        BottomBarScreen.Profile.route -> {
            "Profile"
        }

        AppScreen.CharacterDetail.route -> {
            "Detail"
        }

        else -> {
            "Now"
        }
    }
}

