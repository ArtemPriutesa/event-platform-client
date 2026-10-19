package ua.education.eventplatform.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import eventplatform.shared.generated.resources.Res
import eventplatform.shared.generated.resources.Outfit_VariableFont_wght
import eventplatform.shared.generated.resources.PlusJakartaSans_VariableFont_wght
import org.jetbrains.compose.resources.Font

@Composable
fun rememberAppTypography(): Typography {
    val plusJakartaSans = FontFamily(
        Font(Res.font.PlusJakartaSans_VariableFont_wght, FontWeight.Normal),
        Font(Res.font.PlusJakartaSans_VariableFont_wght, FontWeight.Medium),
        Font(Res.font.PlusJakartaSans_VariableFont_wght, FontWeight.Bold)
    )

    val outfit = FontFamily(
        Font(Res.font.Outfit_VariableFont_wght, FontWeight.Normal),
        Font(Res.font.Outfit_VariableFont_wght, FontWeight.Medium),
        Font(Res.font.Outfit_VariableFont_wght, FontWeight.Bold)
    )

    return remember(plusJakartaSans, outfit) {
        Typography(
            displayLarge = TextStyle(
                fontFamily = outfit,
                fontWeight = FontWeight.Bold
            ),
            displayMedium = TextStyle(
                fontFamily = outfit,
                fontWeight = FontWeight.Bold
            ),
            displaySmall = TextStyle(
                fontFamily = outfit,
                fontWeight = FontWeight.Bold
            ),
            headlineLarge = TextStyle(
                fontFamily = outfit,
                fontWeight = FontWeight.Bold
            ),
            headlineMedium = TextStyle(
                fontFamily = outfit,
                fontWeight = FontWeight.Bold
            ),
            headlineSmall = TextStyle(
                fontFamily = outfit,
                fontWeight = FontWeight.Bold
            ),
            titleLarge = TextStyle(
                fontFamily = outfit,
                fontWeight = FontWeight.SemiBold
            ),
            titleMedium = TextStyle(
                fontFamily = outfit,
                fontWeight = FontWeight.Medium
            ),
            titleSmall = TextStyle(
                fontFamily = outfit,
                fontWeight = FontWeight.Medium
            ),
            bodyLarge = TextStyle(
                fontFamily = plusJakartaSans,
                fontWeight = FontWeight.Normal
            ),
            bodyMedium = TextStyle(
                fontFamily = plusJakartaSans,
                fontWeight = FontWeight.Normal
            ),
            bodySmall = TextStyle(
                fontFamily = plusJakartaSans,
                fontWeight = FontWeight.Normal
            ),
            labelLarge = TextStyle(
                fontFamily = plusJakartaSans,
                fontWeight = FontWeight.Medium
            ),
            labelMedium = TextStyle(
                fontFamily = plusJakartaSans,
                fontWeight = FontWeight.Medium
            ),
            labelSmall = TextStyle(
                fontFamily = plusJakartaSans,
                fontWeight = FontWeight.Medium
            )
        )
    }
}
