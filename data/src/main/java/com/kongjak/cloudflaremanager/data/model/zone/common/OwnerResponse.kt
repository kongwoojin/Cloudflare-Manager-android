package com.kongjak.cloudflaremanager.data.model.zone.common

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.Owner

data class OwnerResponse(
    override val email: Any,
    override val id: Any,
    override val type: String
) : Owner
