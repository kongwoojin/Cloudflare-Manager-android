package com.kongjak.cloudflaremanager.data.model

import com.kongjak.cloudflaremanager.domain.model.interfaces.TenantUnit

data class TenantUnitResponse(
    override val id: Any
): TenantUnit