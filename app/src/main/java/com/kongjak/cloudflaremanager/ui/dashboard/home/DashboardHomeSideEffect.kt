package com.kongjak.cloudflaremanager.ui.dashboard.home

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.Error

sealed class DashboardHomeSideEffect {
    data class APIFailed(val errorMessage: List<Error>) : DashboardHomeSideEffect()
}
