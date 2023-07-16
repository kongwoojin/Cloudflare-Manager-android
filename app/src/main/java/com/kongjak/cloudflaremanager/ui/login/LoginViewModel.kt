package com.kongjak.cloudflaremanager.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kongjak.cloudflaremanager.domain.repository.CloudflareRepository
import com.kongjak.cloudflaremanager.domain.usecase.GetUserTokenUseCase
import com.kongjak.cloudflaremanager.domain.usecase.SetUserTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserTokenUseCase: GetUserTokenUseCase,
    private val setUserTokenUseCase: SetUserTokenUseCase
): ViewModel() {

    fun addUserData(token: String) {
        CoroutineScope(Dispatchers.IO).launch {
            setUserTokenUseCase(token)
        }
    }
}
