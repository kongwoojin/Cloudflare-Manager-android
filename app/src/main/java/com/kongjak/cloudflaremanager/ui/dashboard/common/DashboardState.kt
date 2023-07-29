package com.kongjak.cloudflaremanager.ui.dashboard.common

data class DashboardState(
    val tokenAvailable: Boolean = false,
    val token: String = "",
    val showDetail: Boolean = false,
    val selectedDomainId: String = ""
)
