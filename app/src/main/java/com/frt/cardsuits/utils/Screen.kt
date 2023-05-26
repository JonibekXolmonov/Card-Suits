package com.frt.cardsuits.utils

sealed class Screen(
    val route: String
) {
    object Menu : Screen("menu")
    object Rule : Screen("rule")
    object Game : Screen("game")
    object Settings : Screen("settings")
    object Score : Screen("score")
}