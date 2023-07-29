package com.kongjak.cloudflaremanager.ui.dashboard.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kongjak.cloudflaremanager.domain.usecase.GetUserTokenUseCase
import com.kongjak.cloudflaremanager.domain.usecase.GetZoneDetailUseCase
import com.kongjak.cloudflaremanager.ui.common.UiState
import com.kongjak.cloudflaremanager.ui.dashboard.home.DashboardHomeSideEffect
import com.kongjak.cloudflaremanager.ui.dashboard.home.DashboardHomeState
import com.kongjak.cloudflaremanager.ui.dashboard.home.join
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
class DashboardDetailViewModel @Inject constructor(
    private val getZoneDetailUseCase: GetZoneDetailUseCase
    ) : ContainerHost<DashboardDetailState, DashboardDetailSideEffect>, ViewModel() {
    override val container = container<DashboardDetailState, DashboardDetailSideEffect>(DashboardDetailState())

    fun getZoneDetail(token: String, id: String) = viewModelScope.launch {
        intent {
            val request = getZoneDetailUseCase(token, id)
            if (request.success) {
                reduce {
                    state.copy(
                        uiState = UiState.Success,
                        result = request.result
                    )
                }
            } else {
                reduce {
                    state.copy(
                        uiState = UiState.Failed
                    )
                }
                postSideEffect(DashboardDetailSideEffect.APIFailed(request.errors))
            }
        }
    }
}