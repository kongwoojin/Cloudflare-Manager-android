package com.kongjak.cloudflaremanager.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kongjak.cloudflaremanager.R

@Preview(showBackground = true)
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var token by remember { mutableStateOf("") }

        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.login_title),
            fontSize = 24.sp
        )

        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = token,
            onValueChange = { token = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text(stringResource(id = R.string.login_token)) }
        )

        Button(onClick = {
            loginViewModel.addUserData(token)
        }) {
            Text(text = stringResource(id = R.string.login_confirm))
        }
    }

}