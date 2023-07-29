package com.kongjak.cloudflaremanager.ui.dashboard

import com.kongjak.cloudflaremanager.domain.model.interfaces.Error

sealed class DashboardSideEffect {
    object TokenUnavailable : DashboardSideEffect()
    data class APIFailed(val errorMessage: List<Error>) : DashboardSideEffect()
}
