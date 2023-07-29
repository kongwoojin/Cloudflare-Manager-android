package com.kongjak.cloudflaremanager.data.model.zone.common

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.Message

data class MessageResponse(
    override val code: Int,
    override val message: String,
    override val type: Any
) : Message
