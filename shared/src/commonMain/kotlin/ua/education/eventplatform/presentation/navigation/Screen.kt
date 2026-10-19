package ua.education.eventplatform.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable
    data object Splash : Screen
    @Serializable
    data object Onboarding : Screen
    @Serializable
    data object Auth : Screen
    @Serializable
    data object Main : Screen
}

@Serializable
sealed class MainTab(val title: String) {
    @Serializable
    data object Home : MainTab("Головна")
    @Serializable
    data object Search : MainTab("Пошук")
    @Serializable
    data object Tickets : MainTab("Квитки")
    @Serializable
    data object Profile : MainTab("Профіль")
}
