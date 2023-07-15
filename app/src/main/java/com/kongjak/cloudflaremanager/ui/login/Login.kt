package com.kongjak.cloudflaremanager.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kongjak.cloudflaremanager.R

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by remember { mutableStateOf("") }
        var apiKey by remember { mutableStateOf("") }

        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.login_title),
            fontSize = 24.sp
        )

        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(stringResource(id = R.string.login_email)) }
        )

        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = apiKey,
            onValueChange = { apiKey = it },
            label = { Text(stringResource(id = R.string.login_api_key)) }
        )

        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.login_confirm))
        }
    }

}