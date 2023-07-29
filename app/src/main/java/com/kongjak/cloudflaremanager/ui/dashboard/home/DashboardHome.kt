package com.kongjak.cloudflaremanager.ui.dashboard.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kongjak.cloudflaremanager.R
import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.Result
import com.kongjak.cloudflaremanager.ui.common.UiState
import com.kongjak.cloudflaremanager.ui.dashboard.common.DashboardViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(token: String, dashboardViewModel: DashboardViewModel, dashboardHomeViewModel: DashboardHomeViewModel = viewModel()) {
    val state = dashboardHomeViewModel.collectAsState().value

    dashboardHomeViewModel.collectSideEffect { handleSideEffect(it) }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        stringResource(id = R.string.dashboard_title),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                scrollBehavior = scrollBehavior
            )
        },
        content = { contentPadding ->
            LaunchedEffect(key1 = Unit) {
                dashboardHomeViewModel.getZones(token)
            }
            if (state.uiState == UiState.Success) {
                val listState = rememberLazyListState()
                LazyColumn(contentPadding = contentPadding, state = listState) {
                    itemsIndexed(state.result!!, key = null) { _, result ->
                        DashboardItem(dashboardViewModel, result)
                    }
                }
                listState.OnBottomReached {
                    dashboardHomeViewModel.loadMore()
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    )
}

@Composable
fun DashboardItem(dashboardViewModel: DashboardViewModel, result: Result) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                dashboardViewModel.setDomainId(result.id)
            }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = result.name, fontSize = 24.sp)
                Text(
                    text = stringResource(
                        id = R.string.dashboard_domain_plan,
                        result.plan.name,
                        result.plan.price,
                        result.plan.currency
                    )
                )
            }
            Column {
                DomainStatus(status = result.status)
            }
        }
    }
}

@Composable
fun DomainStatus(status: String) {
    if (status == "active") {
        Icon(
            painter = painterResource(id = R.drawable.domain_status_active),
            contentDescription = status
        )
    } else {
        Icon(
            painter = painterResource(id = R.drawable.domain_status_inactive),
            contentDescription = status
        )
    }
}

private fun handleSideEffect(sideEffect: DashboardHomeSideEffect) {
    when (sideEffect) {
        is DashboardHomeSideEffect.APIFailed -> {}
    }
}

@Composable
fun LazyListState.OnBottomReached(
    loadMore: () -> Unit
) {
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull()
                ?: return@derivedStateOf true

            lastVisibleItem.index == layoutInfo.totalItemsCount - 1
        }
    }

    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .collect {
                if (it) loadMore()
            }
    }
}
