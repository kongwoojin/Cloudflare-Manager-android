package com.kongjak.cloudflaremanager.data.model

import com.kongjak.cloudflaremanager.domain.model.interfaces.Tenant

data class TenantResponse(
    override val id: Any,
    override val name: Any
): Tenant