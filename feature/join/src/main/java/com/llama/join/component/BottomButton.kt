package com.llama.join.component

import androidx.compose.foundation.background
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
private val Grey02 = Color(0xFFF0F2F5)
private val Grey05 = Color(0xFFC7CBD1)

@Composable
fun BottomButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(if (enabled) PrimaryBlack else Grey02)
            .then(
                if (enabled) Modifier.clickable(onClick = onClick)
                else Modifier
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = if (enabled) Color.White else Grey05,
                textAlign = TextAlign.Center,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomButtonDisabled() {
    BottomButton(text = "다음", enabled = false, onClick = {})
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomButtonEnabled() {
    BottomButton(text = "다음", enabled = true, onClick = {})
}
