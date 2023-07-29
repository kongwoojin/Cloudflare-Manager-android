package com.kongjak.cloudflaremanager.ui.dashboard.common

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.Error

sealed class DashboardSideEffect {
    object TokenAvailable : DashboardSideEffect()
    object TokenUnavailable : DashboardSideEffect()
}
