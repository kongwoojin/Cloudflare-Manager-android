package com.kongjak.cloudflaremanager.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kongjak.cloudflaremanager.domain.model.interfaces.Result
import com.kongjak.cloudflaremanager.domain.usecase.GetUserTokenUseCase
import com.kongjak.cloudflaremanager.domain.usecase.GetZonesUseCase
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
class DashboardViewModel @Inject constructor(
    private val getUserTokenUseCase: GetUserTokenUseCase,
    private val getZonesUseCase: GetZonesUseCase
) : ContainerHost<DashboardState, DashboardSideEffect>, ViewModel() {

    override val container = container<DashboardState, DashboardSideEffect>(DashboardState())

    private val _token = MutableStateFlow("")
    val token = _token.asStateFlow()

    init {
        getToken()
    }

    private fun getToken() = viewModelScope.launch {
        intent {
            reduce { state.copy(uiState = UiState.Loading) }
            val token = getUserTokenUseCase()
            if (token != null && token != "") {
                reduce {
                    state.copy(
                        tokenAvailable = true
                    )
                }
                _token.value = token
                getZones()
            } else {
                reduce {
                    state.copy(
                        uiState = UiState.Failed,
                        tokenAvailable = false
                    )
                }
                postSideEffect(DashboardSideEffect.TokenUnavailable)
            }
        }
    }

    private fun getZones() = viewModelScope.launch {
        intent {
            val request = getZonesUseCase(token.value, state.currentPage)
            if (request.success) {
                reduce {
                    state.copy(
                        uiState = UiState.Success,
                        result = request.result?.let { state.result?.join(it) },
                        isLastPage = request.resultInfo!!.totalPages <= state.currentPage
                    )
                }
            } else {
                reduce {
                    state.copy(
                        uiState = UiState.Failed
                    )
                }
                postSideEffect(DashboardSideEffect.APIFailed(request.errors))
            }
        }
    }

    fun loadMore() {
        intent {
            if (!state.isLastPage) {
                reduce {
                    state.copy(
                        currentPage = state.currentPage.plus(1)
                    )
                }
            }
        }
    }
}

fun List<Result>.join(list: List<Result>): List<Result> {
    val mutableList = this.toMutableList()
    mutableList.addAll(list)
    return mutableList.toList()
}