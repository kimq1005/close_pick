package com.llama.join.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val ActiveColor = Color(0xFF148EED)
private val InactiveColor = Color(0xFFC7CBD1)

@Composable
fun StepIndicator(
    totalSteps: Int,
    currentStep: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        repeat(totalSteps) { index ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(
                        if (index < currentStep) ActiveColor else InactiveColor
                    ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewStepIndicator() {
    StepIndicator(totalSteps = 3, currentStep = 2)
}
