package com.kongjak.cloudflaremanager.ui.dashboard.detail

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.Result
import com.kongjak.cloudflaremanager.ui.common.UiState

data class DashboardDetailState(
    val uiState: UiState = UiState.Initial,
    val result: Result? = null
)