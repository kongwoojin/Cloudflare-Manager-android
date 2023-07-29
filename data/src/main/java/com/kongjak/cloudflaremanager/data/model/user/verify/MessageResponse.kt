package com.kongjak.cloudflaremanager.data.model.user.verify

import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Message

data class MessageResponse(
    override val code: Int,
    override val message: String,
    override val type: Any
) : Message
