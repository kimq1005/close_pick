package com.llama.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class HomeState(
    val id: String = "",
    val password: String = "",
)

sealed interface HomeIntent {
    data class UpdateId(val id: String) : HomeIntent
    data class UpdatePassword(val password: String) : HomeIntent
    data object Login : HomeIntent
}

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.UpdateId -> _state.update { it.copy(id = intent.id) }
            is HomeIntent.UpdatePassword -> _state.update { it.copy(password = intent.password) }
            is HomeIntent.Login -> login()
        }
    }

    private fun login() {
        // TODO: UseCase 연동
    }
}