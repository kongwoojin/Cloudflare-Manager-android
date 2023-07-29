package com.kongjak.cloudflaremanager.data.model.zone.detail

import com.kongjak.cloudflaremanager.data.model.zone.common.ResultResponse
import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.detail.ZoneDetail

data class ZoneDetailResponse(
    override val errors: List<ErrorResponse>,
    override val messages: List<Any>,
    override val result: ResultResponse,
    override val success: Boolean
) : ZoneDetail
