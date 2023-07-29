package com.kongjak.cloudflaremanager.ui.dashboard.home

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.Result
import com.kongjak.cloudflaremanager.ui.common.UiState

data class DashboardHomeState(
    val uiState: UiState = UiState.Initial,
    val tokenAvailable: Boolean = false,
    val result: List<Result>? = emptyList(),
    val currentPage: Int = 1,
    val isLastPage: Boolean = false,
)
