package com.example.githubusersapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import android.util.Log


@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
            ListScreen(navController)
        }
        composable("detail/{login}") { backStackEntry ->
            val login =
                backStackEntry.arguments?.getString("login") ?: ""
            Log.d("NAV_TEST", "DetailScreen: $login")
            DetailScreen(login)
        }
    }
}