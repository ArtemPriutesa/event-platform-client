package ua.education.eventplatform.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collect
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import ua.education.eventplatform.domain.usecase.IsOnboardingCompletedUseCase
import ua.education.eventplatform.presentation.screen.AuthScreen
import ua.education.eventplatform.presentation.screen.MainScreen
import ua.education.eventplatform.presentation.screen.SplashScreen
import ua.education.eventplatform.presentation.screen.onboarding.OnboardingEffect
import ua.education.eventplatform.presentation.screen.onboarding.OnboardingPagerScreen
import ua.education.eventplatform.presentation.screen.onboarding.OnboardingViewModel

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    val isOnboardingCompleted: IsOnboardingCompletedUseCase = koinInject()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash
    ) {
        composable<Screen.Splash> {
            SplashScreen(
                onSplashFinished = {
                    val destination = if (isOnboardingCompleted()) {
                        Screen.Auth
                    } else {
                        Screen.Onboarding
                    }
                    navController.navigate(destination) {
                        popUpTo<Screen.Splash> { inclusive = true }
                    }
                }
            )
        }
        composable<Screen.Onboarding> {
            val onboardingViewModel = koinViewModel<OnboardingViewModel>()
            val state by onboardingViewModel.state.collectAsState()

            LaunchedEffect(onboardingViewModel) {
                onboardingViewModel.effects.collect { effect ->
                    when (effect) {
                        OnboardingEffect.NavigateToAuth -> navController.navigate(Screen.Auth) {
                            popUpTo<Screen.Onboarding> { inclusive = true }
                        }
                    }
                }
            }

            OnboardingPagerScreen(
                state = state,
                onIntent = onboardingViewModel::onIntent,
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
