package com.halil.sosyalkampus.navigation

enum class SocialCampusScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreenFirst,
    CreateAccountScreenSecond,
    HomeScreen;

    companion object {
        fun fromRoute(route: String): SocialCampusScreens = when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            CreateAccountScreenFirst.name -> CreateAccountScreenFirst
            CreateAccountScreenSecond.name -> CreateAccountScreenSecond
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}