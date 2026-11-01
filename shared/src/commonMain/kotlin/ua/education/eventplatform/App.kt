package ua.education.eventplatform

import androidx.compose.runtime.Composable
import org.koin.compose.KoinContext
import ua.education.eventplatform.presentation.navigation.NavigationHost
import ua.education.eventplatform.presentation.theme.AppTheme

@Composable
fun App() {
    KoinContext {
        AppTheme {
            NavigationHost()
        }
    }
}
