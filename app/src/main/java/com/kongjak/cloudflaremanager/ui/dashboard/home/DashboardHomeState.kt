package com.kongjak.cloudflaremanager.ui.dashboard

import com.kongjak.cloudflaremanager.domain.model.interfaces.Result
import com.kongjak.cloudflaremanager.ui.common.UiState

data class DashboardState(
    val uiState: UiState = UiState.Initial,
    val tokenAvailable: Boolean = false,
    val result: List<Result>? = emptyList(),
    val currentPage: Int = 1,
    val isLastPage: Boolean = false
)
