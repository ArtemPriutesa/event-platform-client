package ua.education.eventplatform.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ua.education.eventplatform.presentation.navigation.MainTab
import ua.education.eventplatform.presentation.screen.main.HomeScreen
import ua.education.eventplatform.presentation.screen.main.ProfileScreen
import ua.education.eventplatform.presentation.screen.main.SearchScreen
import ua.education.eventplatform.presentation.screen.main.TicketsScreen

@Composable
fun MainScreen() {
    var currentTab by remember { mutableStateOf<MainTab>(MainTab.Home) }

    val tabs = listOf(
        Triple(MainTab.Home, Icons.Default.Home, "Головна"),
        Triple(MainTab.Search, Icons.Default.Search, "Пошук"),
        Triple(MainTab.Tickets, Icons.Default.ConfirmationNumber, "Квитки"),
        Triple(MainTab.Profile, Icons.Default.Person, "Профіль")
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar {
                tabs.forEach { (tab, icon, label) ->
                    NavigationBarItem(
                        selected = currentTab == tab,
                        onClick = { currentTab = tab },
                        icon = { Icon(imageVector = icon, contentDescription = label) },
                        label = { Text(label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentTab) {
                is MainTab.Home -> HomeScreen()
                is MainTab.Search -> SearchScreen()
                is MainTab.Tickets -> TicketsScreen()
                is MainTab.Profile -> ProfileScreen()
            }
        }
    }
}
