package com.kongjak.cloudflaremanager.ui.dashboard.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun DashboardDetail(
    token: String,
    id: String,
    dashboardDetailViewModel: DashboardDetailViewModel = viewModel()
) {
    val state = dashboardDetailViewModel.collectSideEffect { handleSideEffect(it) }

    LaunchedEffect(key1 = Unit) {
        dashboardDetailViewModel.getZoneDetail(token, id)
    }

}

private fun handleSideEffect(sideEffect: DashboardDetailSideEffect) {
    when (sideEffect) {
        is DashboardDetailSideEffect.APIFailed -> {}
    }
}