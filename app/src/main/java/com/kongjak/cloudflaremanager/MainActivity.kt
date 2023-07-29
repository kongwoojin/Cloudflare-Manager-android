package com.kongjak.cloudflaremanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kongjak.cloudflaremanager.ui.dashboard.common.DashboardViewModel
import com.kongjak.cloudflaremanager.ui.dashboard.detail.DashboardDetail
import com.kongjak.cloudflaremanager.ui.dashboard.home.Dashboard
import com.kongjak.cloudflaremanager.ui.login.LoginScreen
import com.kongjak.cloudflaremanager.ui.login.LoginViewModel
import com.kongjak.cloudflaremanager.ui.theme.CloudflareManagerTheme
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectAsState

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val dashboardViewModel: DashboardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloudflareManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val loginState = loginViewModel.collectAsState().value
                    val dashboardState = dashboardViewModel.collectAsState().value
                    if (loginState.isVerified) {
                        if (dashboardState.showDetail) {
                            DashboardDetail(dashboardState.token, dashboardState.selectedDomainId)
                        } else {
                            Dashboard(dashboardState.token, dashboardViewModel)
                        }
                    } else {
                        LoginScreen(loginViewModel = loginViewModel)
                    }
                }
            }
        }
    }
}
