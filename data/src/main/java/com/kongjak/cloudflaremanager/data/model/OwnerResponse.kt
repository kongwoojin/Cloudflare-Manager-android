package com.kongjak.cloudflaremanager.data.model

import com.kongjak.cloudflaremanager.domain.model.interfaces.Owner

data class OwnerResponse(
    override val email: Any,
    override val id: Any,
    override val type: String
): Owner