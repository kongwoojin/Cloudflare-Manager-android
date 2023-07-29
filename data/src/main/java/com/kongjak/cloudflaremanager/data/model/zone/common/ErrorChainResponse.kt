package com.kongjak.cloudflaremanager.data.model.zone.common

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.ErrorChain

data class ErrorChainResponse(
    override val code: Int,
    override val message: String
) : ErrorChain
