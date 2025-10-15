package com.samueljuma.basenetworkapp.ui.navigation

sealed class AppScreens(val route: String) {
    object FirstScreen : AppScreens("first_screen")
    object SecondScreen : AppScreens("second_screen")
}