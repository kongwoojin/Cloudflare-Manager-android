package com.kongjak.cloudflaremanager.data.model.zone.detail

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.detail.Error

data class ErrorResponse(
    override val code: Int,
    override val message: String
) : Error
