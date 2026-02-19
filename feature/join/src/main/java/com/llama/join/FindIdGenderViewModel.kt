package com.llama.join

import androidx.lifecycle.ViewModel
import com.llama.join.model.FindIdGenderIntent
import com.llama.join.model.FindIdGenderState
import com.llama.join.model.Gender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FindIdGenderViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(FindIdGenderState())
    val state: StateFlow<FindIdGenderState> = _state.asStateFlow()

    fun handleIntent(intent: FindIdGenderIntent) {
        when (intent) {
            is FindIdGenderIntent.SelectGender -> _state.update { it.copy(selectedGender = intent.gender) }
            is FindIdGenderIntent.ClickNext -> navigateNext()
            is FindIdGenderIntent.ClickBack -> navigateBack()
        }
    }

    private fun navigateNext() {
        // TODO: Navigation 연동
    }

    private fun navigateBack() {
        // TODO: Navigation 연동
    }
}
