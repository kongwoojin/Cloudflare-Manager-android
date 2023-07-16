package com.kongjak.cloudflaremanager.ui.login

import com.kongjak.cloudflaremanager.ui.common.UiState

data class LoginState(
    val uiState: UiState = UiState.Initial,
    val isVerified: Boolean = false
)
