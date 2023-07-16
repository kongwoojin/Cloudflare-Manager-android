package com.kongjak.cloudflaremanager.data.model

import com.google.gson.annotations.SerializedName
import com.kongjak.cloudflaremanager.domain.model.interfaces.Zones

data class ZonesResponse(
    override val errors: List<ErrorResponse>,
    override val messages: List<Any>,
    override val result: List<ResultResponse>?,
    @SerializedName("result_info")
    override val resultInfo: ResultInfoResponse?,
    override val success: Boolean
): Zones