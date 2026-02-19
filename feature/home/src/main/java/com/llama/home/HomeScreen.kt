package com.llama.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeSuccessScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    HomeScreen(
        state = state,
        onIntent = viewModel::handleIntent,
    )
}

@Composable
private fun HomeScreen(
    state: HomeState = HomeState(),
    onIntent: (HomeIntent) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        OutlinedTextField(
            value = state.id,
            onValueChange = { onIntent(HomeIntent.UpdateId(it)) },
            label = { Text("아이디") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = state.password,
            onValueChange = { onIntent(HomeIntent.UpdatePassword(it)) },
            label = { Text("비밀번호") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onIntent(HomeIntent.Login) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("로그인")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}