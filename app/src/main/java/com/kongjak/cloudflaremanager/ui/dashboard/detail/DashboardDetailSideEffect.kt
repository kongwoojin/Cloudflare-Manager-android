package com.kongjak.cloudflaremanager.ui.dashboard.detail

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.detail.Error

sealed class DashboardDetailSideEffect {
    data class APIFailed(val errorMessage: List<Error>) : DashboardDetailSideEffect()
}