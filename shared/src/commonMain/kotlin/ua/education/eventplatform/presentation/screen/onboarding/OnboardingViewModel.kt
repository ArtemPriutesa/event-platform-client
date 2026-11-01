package ua.education.eventplatform.presentation.screen.onboarding

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import ua.education.eventplatform.domain.usecase.CompleteOnboardingUseCase

class OnboardingViewModel(
    private val completeOnboarding: CompleteOnboardingUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(OnboardingState())
    val state = _state.asStateFlow()

    private val _effects = Channel<OnboardingEffect>(Channel.BUFFERED)
    val effects = _effects.receiveAsFlow()

    fun onIntent(intent: OnboardingIntent) {
        when (intent) {
            OnboardingIntent.NextPage -> {
                val currentPage = _state.value.currentPage
                if (currentPage >= _state.value.totalPages - 1) {
                    completeOnboarding()
                } else {
                    _state.value = _state.value.copy(currentPage = currentPage + 1)
                }
            }

            OnboardingIntent.PreviousPage -> {
                _state.value = _state.value.copy(
                    currentPage = (_state.value.currentPage - 1).coerceAtLeast(0),
                )
            }

            is OnboardingIntent.PageChanged -> {
                _state.value = _state.value.copy(
                    currentPage = intent.page.coerceIn(0, _state.value.totalPages - 1),
                )
            }

            OnboardingIntent.SkipOnboarding,
            OnboardingIntent.CompleteOnboarding -> completeOnboarding()
        }
    }

    private fun completeOnboarding() {
        if (_state.value.isCompleted) return

        _state.value = _state.value.copy(isCompleted = true)
        _effects.trySend(OnboardingEffect.NavigateToAuth)
    }
}
