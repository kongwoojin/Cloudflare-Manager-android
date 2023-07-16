package com.kongjak.cloudflaremanager.data.model.user.verify

import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Result

data class ResultResponse(
    override val id: String,
    override val status: String
) : Result