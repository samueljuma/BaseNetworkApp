package com.samueljuma.basenetworkapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samueljuma.basenetworkapp.ui.screens.FirstScreen
import com.samueljuma.basenetworkapp.ui.screens.SecondScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.FirstScreen.route
    ) {
        composable(AppScreens.FirstScreen.route){
            FirstScreen(
                onClickMe = {
                    navController.navigate(AppScreens.SecondScreen.route)
                }
            )
        }
        composable(AppScreens.SecondScreen.route){
            SecondScreen()
        }
    }
}