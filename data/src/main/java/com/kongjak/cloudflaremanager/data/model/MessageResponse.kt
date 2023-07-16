package com.kongjak.cloudflaremanager.data.model

import com.kongjak.cloudflaremanager.domain.model.interfaces.Message

data class MessageResponse(
    override val code: Int,
    override val message: String,
    override val type: Any
): Message