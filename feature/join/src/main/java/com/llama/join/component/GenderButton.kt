package com.llama.join.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PrimaryBlack = Color(0xFF21242E)
private val PrimaryBlue = Color(0xFF148EED)
private val Grey02 = Color(0xFFF0F2F5)

@Composable
fun GenderButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(
                width = 1.dp,
                color = if (selected) PrimaryBlue else Grey02,
                shape = RoundedCornerShape(10.dp),
            )
            .background(Color.White)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = if (selected) PrimaryBlue else PrimaryBlack,
                textAlign = TextAlign.Center,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGenderButton() {
    GenderButton(text = "여성", selected = false, onClick = {})
}

@Preview(showBackground = true)
@Composable
private fun PreviewGenderButtonSelected() {
    GenderButton(text = "남성", selected = true, onClick = {})
}
