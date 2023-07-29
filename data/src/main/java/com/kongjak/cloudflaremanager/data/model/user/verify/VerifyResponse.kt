package com.kongjak.cloudflaremanager.data.model.user.verify

import com.kongjak.cloudflaremanager.data.model.zone.common.ErrorResponse
import com.kongjak.cloudflaremanager.data.model.zone.common.MessageResponse
import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Verify

data class VerifyResponse(
    override val errors: List<ErrorResponse>,
    override val messages: List<MessageResponse>,
    override val result: ResultResponse,
    override val success: Boolean
) : Verify
