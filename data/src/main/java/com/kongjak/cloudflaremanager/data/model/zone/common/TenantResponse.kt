package com.kongjak.cloudflaremanager.data.model.zone.common

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.Tenant

data class TenantResponse(
    override val id: Any,
    override val name: Any
) : Tenant
