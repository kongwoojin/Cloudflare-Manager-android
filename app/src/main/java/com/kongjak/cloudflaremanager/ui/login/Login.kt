package com.kongjak.cloudflaremanager.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kongjak.cloudflaremanager.R
import com.kongjak.cloudflaremanager.ui.common.UiState
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    val state = loginViewModel.collectAsState().value
    val token = loginViewModel.token.collectAsState().value

    loginViewModel.collectSideEffect { handleSideEffect(it) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.uiState == UiState.Loading) {
            CircularProgressIndicator()
        } else {
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(id = R.string.login_title),
                fontSize = 24.sp
            )

            OutlinedTextField(
                modifier = Modifier.padding(16.dp),
                value = token,
                onValueChange = loginViewModel::setToken,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text(stringResource(id = R.string.login_token)) }
            )

            Button(onClick = {
                loginViewModel.verifyToken(token)
            }) {
                Text(text = stringResource(id = R.string.login_confirm))
            }
        }
    }
}

private fun handleSideEffect(sideEffect: LoginSideEffect) {
    when (sideEffect) {
        is LoginSideEffect.Failed -> {}
    }
}
