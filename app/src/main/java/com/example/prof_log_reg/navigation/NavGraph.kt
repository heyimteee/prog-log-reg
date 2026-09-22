package com.example.prof_log_reg.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.prof_log_reg.screens.AvatarScreen
import com.example.prof_log_reg.screens.LoginScreen
import com.example.prof_log_reg.screens.ProfileScreen
import com.example.prof_log_reg.screens.RegisterScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    sessionViewModel: com.example.prof_log_reg.model.SessionViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(
                navController = navController,
                sessionViewModel = sessionViewModel
            )
        }
        composable(Routes.REGISTER) {
            RegisterScreen(
                navController = navController,
                sessionViewModel = sessionViewModel
            )
        }
        composable(Routes.PROFILE) {
            ProfileScreen(
                navController = navController,
                sessionViewModel = sessionViewModel
            )
        }
        composable(Routes.AVATAR) {
            AvatarScreen()
        }
    }
}
