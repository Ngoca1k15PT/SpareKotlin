package com.hn.sprase.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hn.sprase.presentation.screen.home.HomeScreen
import com.hn.sprase.presentation.screen.login.LoginScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routers.homeScreen, builder = {
        composable(Routers.loginScreen){
            LoginScreen(navController)
        }

        composable(Routers.homeScreen) {
            HomeScreen()
        }
    })
}