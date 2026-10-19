package ua.education.eventplatform.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ua.education.eventplatform.presentation.screen.AuthScreen
import ua.education.eventplatform.presentation.screen.MainScreen
import ua.education.eventplatform.presentation.screen.OnboardingPagerScreen
import ua.education.eventplatform.presentation.screen.SplashScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash
    ) {
        composable<Screen.Splash> {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(Screen.Onboarding) {
                    popUpTo<Screen.Splash> { inclusive = true }
                    }
                }
            )
        }
        composable<Screen.Onboarding> {
            OnboardingPagerScreen(
                onFinish = {
                    navController.navigate(Screen.Auth) {
                        popUpTo<Screen.Onboarding> { inclusive = true }
                    }
                },
                onSkip = {
                    navController.navigate(Screen.Auth) {
                        popUpTo<Screen.Onboarding> { inclusive = true }
                    }
                }
            )
        }
        composable<Screen.Auth> {
            AuthScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Main) {
                        popUpTo<Screen.Auth> { inclusive = true }
                    }
                }
            )
        }
        composable<Screen.Main> {
            MainScreen()
        }
    }
}
