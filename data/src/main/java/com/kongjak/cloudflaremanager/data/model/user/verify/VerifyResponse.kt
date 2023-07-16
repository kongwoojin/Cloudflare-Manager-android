package com.kongjak.cloudflaremanager.data.model.user.verify

import com.kongjak.cloudflaremanager.data.model.ErrorResponse
import com.kongjak.cloudflaremanager.data.model.MessageResponse
import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Verify

data class VerifyResponse(
    override val errors: List<ErrorResponse>,
    override val messages: List<MessageResponse>,
    override val result: List<ResultResponse>,
    override val success: Boolean
) : Verify
