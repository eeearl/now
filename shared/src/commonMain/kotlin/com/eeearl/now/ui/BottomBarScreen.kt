package com.eeearl.now.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    var title: String,
    val defaultIcon: ImageVector,
) {
    data object Home : BottomBarScreen(
        route = "nav_character",
        title = "Home",
        defaultIcon = Icons.Filled.Home,
    )
    data object Detail : BottomBarScreen(

        route = "nav_character_detail",
        title = "Detail",
        defaultIcon = Icons.Filled.Home,
    )

    data object Reels : BottomBarScreen(
        route = "REELS",
        title = "Reels",
        defaultIcon = Icons.Filled.Home
    )

    data object Profile : BottomBarScreen(
        route = "PROFILE",
        title = "Profile",
        defaultIcon = Icons.Filled.AccountBox
    )
}
