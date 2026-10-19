package ua.education.eventplatform

import androidx.compose.runtime.Composable
import ua.education.eventplatform.presentation.navigation.NavigationHost
import ua.education.eventplatform.presentation.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        NavigationHost()
    }
}
