package com.kongjak.cloudflaremanager.ui.dashboard.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.Result
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
class DashboardHomeViewModel @Inject constructor(
    private val getZonesUseCase: GetZonesUseCase
) : ContainerHost<DashboardHomeState, DashboardHomeSideEffect>, ViewModel() {

    override val container = container<DashboardHomeState, DashboardHomeSideEffect>(DashboardHomeState())

    fun getZones(token: String) = viewModelScope.launch {
        intent {
            val request = getZonesUseCase(token, state.currentPage)
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
                postSideEffect(DashboardHomeSideEffect.APIFailed(request.errors))
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