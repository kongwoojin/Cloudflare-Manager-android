package com.kongjak.cloudflaremanager.ui.common

sealed class UiState {
    object Initial : UiState()
    object Loading : UiState()
    object Success : UiState()
    object Failed : UiState()
}
