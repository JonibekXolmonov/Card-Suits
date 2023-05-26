package com.frt.cardsuits.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.frt.cardsuits.screens.game.GameScreen
import com.frt.cardsuits.screens.menu.MenuScreen
import com.frt.cardsuits.screens.rule.RuleScreen
import com.frt.cardsuits.screens.score.ScoreScreen
import com.frt.cardsuits.screens.settings.SettingsScreen
import com.frt.cardsuits.utils.Screen

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Menu.route,
    onVibrate: () -> Unit,
    onSound: (Boolean) -> Unit
) {
    NavHost(
        navController,
        startDestination = startDestination,
    ) {
        composable(route = Screen.Menu.route) {
            MenuScreen(
                onRulesClick = {
                    navController.navigate(Screen.Rule.route)
                    onVibrate()
                },
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                    onVibrate()
                },
                onGameStartClick = {
                    navController.navigate(Screen.Game.route)
                    onVibrate()
                }
            )
        }

        composable(route = Screen.Rule.route) {
            RuleScreen {
                navController.popBackStack()
                onVibrate()
            }
        }

        composable(
            route = Screen.Game.route,
        ) {
            GameScreen(onVibrate = onVibrate) {
                navController.navigate(Screen.Score.route.plus("/$it"))
            }
        }

        composable(
            route = Screen.Score.route.plus("/{score}"),
            arguments = listOf(navArgument("score") { type = NavType.IntType })
        ) {
            val score = it.arguments?.getInt("score",15)
            ScoreScreen(score = score)
        }

        composable(route = Screen.Settings.route) {
            SettingsScreen(
                onBackPressed = {
                    navController.popBackStack()
                    onVibrate()
                },
                onSound = onSound,
                onVibrate = onVibrate
            )
        }
    }
}