package com.llama.join.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.join.component.GenderButton
import com.llama.join.model.Gender

@Composable
fun FindIdGenderBodySection(
    selectedGender: Gender?,
    onSelectGender: (Gender) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        GenderButton(
            text = "여성",
            selected = selectedGender == Gender.FEMALE,
            onClick = { onSelectGender(Gender.FEMALE) },
        )
        GenderButton(
            text = "남성",
            selected = selectedGender == Gender.MALE,
            onClick = { onSelectGender(Gender.MALE) },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFindIdGenderBodySection() {
    FindIdGenderBodySection(selectedGender = null, onSelectGender = {})
}

@Preview(showBackground = true)
@Composable
private fun PreviewFindIdGenderBodySectionSelected() {
    FindIdGenderBodySection(selectedGender = Gender.FEMALE, onSelectGender = {})
}
