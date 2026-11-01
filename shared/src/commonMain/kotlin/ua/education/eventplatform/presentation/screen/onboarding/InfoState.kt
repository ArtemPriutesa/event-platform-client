package ua.education.eventplatform.presentation.screen.onboarding

data class OnboardingState(
    val currentPage: Int = 0,
    val totalPages: Int = 4,
    val isCompleted: Boolean = false
)
