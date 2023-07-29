package com.kongjak.cloudflaremanager.data.model.user.verify

import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.ErrorChain

data class ErrorChainResponse(
    override val code: Int,
    override val message: String
) : ErrorChain
