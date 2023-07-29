package com.kongjak.cloudflaremanager.ui.dashboard.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kongjak.cloudflaremanager.domain.usecase.GetUserTokenUseCase
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
class DashboardViewModel @Inject constructor(
    private val getUserTokenUseCase: GetUserTokenUseCase
) : ContainerHost<DashboardState, DashboardSideEffect>, ViewModel() {

    override val container = container<DashboardState, DashboardSideEffect>(DashboardState())

    private val _token = MutableStateFlow("")
    val token = _token.asStateFlow()

    init {
        getToken()
    }

    private fun getToken() = viewModelScope.launch {
        intent {
            val token = getUserTokenUseCase()
            if (token != null && token != "") {
                reduce {
                    state.copy(
                        tokenAvailable = true,
                        token = token
                    )
                }
                _token.value = token
                postSideEffect(DashboardSideEffect.TokenAvailable)
            } else {
                reduce {
                    state.copy(
                        tokenAvailable = false
                    )
                }
                postSideEffect(DashboardSideEffect.TokenUnavailable)
            }
        }
    }

    fun setDomainId(id: String) {
        intent {
            reduce {
                state.copy(
                    showDetail = true,
                    selectedDomainId = id
                )
            }
        }
    }
}
