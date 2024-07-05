package com.eeearl.now.ui
sealed class AppScreen(val route: String) {
    data object CharacterTop: AppScreen("nav_character")
    data object CharacterDetail : AppScreen("nav_character_detail")
}
