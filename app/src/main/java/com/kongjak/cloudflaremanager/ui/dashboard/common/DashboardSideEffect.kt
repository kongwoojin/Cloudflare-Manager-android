package com.kongjak.cloudflaremanager.ui.dashboard.common

sealed class DashboardSideEffect {
    object TokenAvailable : DashboardSideEffect()
    object TokenUnavailable : DashboardSideEffect()
}
