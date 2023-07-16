package com.kongjak.cloudflaremanager.ui.login

import com.kongjak.cloudflaremanager.domain.model.interfaces.Error

sealed class LoginSideEffect {
    data class Failed(val errorMessage: List<Error>) : LoginSideEffect()
}
