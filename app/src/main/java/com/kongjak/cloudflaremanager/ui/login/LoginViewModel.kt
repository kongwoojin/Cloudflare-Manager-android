package com.kongjak.cloudflaremanager.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kongjak.cloudflaremanager.domain.usecase.GetUserTokenUseCase
import com.kongjak.cloudflaremanager.domain.usecase.SetUserTokenUseCase
import com.kongjak.cloudflaremanager.domain.usecase.VerifyTokenUseCase
import com.kongjak.cloudflaremanager.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserTokenUseCase: GetUserTokenUseCase,
    private val setUserTokenUseCase: SetUserTokenUseCase,
    private val verifyTokenUseCase: VerifyTokenUseCase
) : ContainerHost<LoginState, LoginSideEffect>, ViewModel() {

    override val container = container<LoginState, LoginSideEffect>(LoginState())

    private val _token = MutableStateFlow("")
    val token = _token.asStateFlow()

    init {
        viewModelScope.launch {
            _token.value = getUserTokenUseCase() ?: ""
        }
    }

    fun setToken(token: String) {
        _token.value = token
    }

    fun verifyToken(token: String) = viewModelScope.launch {
        intent {
            reduce { state.copy(uiState = UiState.Loading) }
            val request = verifyTokenUseCase(token)
            if (request.success) {
                reduce {
                    state.copy(
                        isVerified = true,
                        uiState = UiState.Success
                    )
                }
                setUserTokenUseCase(token)
            } else {
                reduce {
                    state.copy(
                        isVerified = false,
                        uiState = UiState.Failed
                    )
                }
                request.errors?.let { postSideEffect(LoginSideEffect.Failed(request.errors!!)) }
            }
        }
    }
}
