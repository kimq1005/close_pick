package com.llama.join

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.llama.join.component.BottomButton
import com.llama.join.model.FindIdGenderIntent
import com.llama.join.model.FindIdGenderState
import com.llama.join.model.Gender
import com.llama.join.section.FindIdGenderBodySection
import com.llama.join.section.FindIdGenderHeaderSection

@Composable
fun FindIdGenderSuccessScreen(
    viewModel: FindIdGenderViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    FindIdGenderScreen(
        state = state,
        onIntent = viewModel::handleIntent,
    )
}

@Composable
private fun FindIdGenderScreen(
    state: FindIdGenderState = FindIdGenderState(),
    onIntent: (FindIdGenderIntent) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        FindIdGenderHeaderSection(
            onClickBack = { onIntent(FindIdGenderIntent.ClickBack) },
            modifier = Modifier.padding(top = 40.dp),
        )

        Spacer(modifier = Modifier.height(40.dp))

        FindIdGenderBodySection(
            selectedGender = state.selectedGender,
            onSelectGender = { onIntent(FindIdGenderIntent.SelectGender(it)) },
            modifier = Modifier.padding(horizontal = 30.dp),
        )

        Spacer(modifier = Modifier.weight(1f))

        BottomButton(
            text = "다음",
            enabled = state.selectedGender != null,
            onClick = { onIntent(FindIdGenderIntent.ClickNext) },
            modifier = Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFindIdGenderScreen() {
    FindIdGenderScreen()
}

@Preview(showBackground = true)
@Composable
private fun PreviewFindIdGenderScreenSelected() {
    FindIdGenderScreen(
        state = FindIdGenderState(selectedGender = Gender.FEMALE),
    )
}
