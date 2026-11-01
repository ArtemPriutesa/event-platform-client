package ua.education.eventplatform.presentation.screen.onboarding

sealed interface OnboardingIntent {
    data object NextPage : OnboardingIntent
    data object PreviousPage : OnboardingIntent
    data class PageChanged(val page: Int) : OnboardingIntent
    data object SkipOnboarding : OnboardingIntent
    data object CompleteOnboarding : OnboardingIntent
}
