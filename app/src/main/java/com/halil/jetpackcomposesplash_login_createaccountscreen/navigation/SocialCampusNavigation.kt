package com.halil.jetpackcomposesplash_login_createaccountscreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.halil.jetpackcomposesplash_login_createaccountscreen.screens.LoginScreen
import com.halil.jetpackcomposesplash_login_createaccountscreen.screens.SplashScreen
import com.halil.sosyalkampus.navigation.CreateAccountScreenFirst
import com.halil.sosyalkampus.navigation.CreateAccountScreenSecond
import com.halil.sosyalkampus.navigation.SocialCampusScreens

@Composable
fun SocialCampusNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SocialCampusScreens.SplashScreen.name
    ) {
        composable(SocialCampusScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(SocialCampusScreens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }
        composable(SocialCampusScreens.CreateAccountScreenFirst.name) {
            CreateAccountScreenFirst(navController = navController)
        }
        composable(SocialCampusScreens.CreateAccountScreenSecond.name) {
            CreateAccountScreenSecond(navController = navController)
        }
    }
    
}