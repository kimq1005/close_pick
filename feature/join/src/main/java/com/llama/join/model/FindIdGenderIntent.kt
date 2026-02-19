package com.llama.join.model

sealed interface FindIdGenderIntent {
    data class SelectGender(val gender: Gender) : FindIdGenderIntent
    data object ClickNext : FindIdGenderIntent
    data object ClickBack : FindIdGenderIntent
}
