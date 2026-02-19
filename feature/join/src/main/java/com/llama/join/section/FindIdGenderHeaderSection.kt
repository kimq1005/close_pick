package com.llama.join.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.join.component.StepIndicator

private val PrimaryBlack = Color(0xFF21242E)

@Composable
fun FindIdGenderHeaderSection(
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        // 뒤로가기 버튼
        IconButton(
            onClick = onClickBack,
            modifier = Modifier.padding(start = 4.dp),
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "뒤로가기",
                tint = PrimaryBlack,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 단계 인디케이터 (2/3)
        StepIndicator(
            totalSteps = 3,
            currentStep = 2,
            modifier = Modifier.padding(start = 30.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 타이틀
        Text(
            text = "아이디 찾기\n성별을 선택해주세요.",
            modifier = Modifier.padding(horizontal = 30.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                lineHeight = 45.sp,
                color = PrimaryBlack,
            ),
        )

        Spacer(modifier = Modifier.height(4.dp))

        // 서브 타이틀
        Text(
            text = "가입 시 선택한 성별과 일치해야 합니다.",
            modifier = Modifier.padding(horizontal = 30.dp),
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 24.sp,
                color = PrimaryBlack,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFindIdGenderHeaderSection() {
    FindIdGenderHeaderSection(onClickBack = {})
}
