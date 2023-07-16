package com.kongjak.cloudflaremanager.data.model

import com.kongjak.cloudflaremanager.domain.model.interfaces.ErrorChain

data class ErrorChainResponse(
    override val code: Int,
    override val message: String
) : ErrorChain
