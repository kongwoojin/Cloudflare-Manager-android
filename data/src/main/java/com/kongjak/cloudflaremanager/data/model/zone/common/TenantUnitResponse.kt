package com.kongjak.cloudflaremanager.data.model.zone.common

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.TenantUnit

data class TenantUnitResponse(
    override val id: Any
) : TenantUnit
