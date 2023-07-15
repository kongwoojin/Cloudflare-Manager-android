package com.kongjak.cloudflaremanager.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.kongjak.cloudflaremanager.domain.usecase.GetUserAPIKeyUseCase
import com.kongjak.cloudflaremanager.domain.usecase.GetUserEmailUseCase
import com.kongjak.cloudflaremanager.domain.usecase.SetUserAPIKeyUseCase
import com.kongjak.cloudflaremanager.domain.usecase.SetUserEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserAPIKeyUseCase: GetUserAPIKeyUseCase,
    private val getUserEmailUseCase: GetUserEmailUseCase,
    private val setUserAPIKeyUseCase: SetUserAPIKeyUseCase,
    private val setUserEmailUseCase: SetUserEmailUseCase
): ViewModel() {

    fun addUserData(email: String, apiKey: String) {
        CoroutineScope(Dispatchers.IO).launch {
            setUserEmailUseCase(email)
            setUserAPIKeyUseCase(apiKey)
        }
    }
}
