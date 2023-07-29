package com.kongjak.cloudflaremanager.data.model.zone.list

import com.google.gson.annotations.SerializedName
import com.kongjak.cloudflaremanager.data.model.zone.common.ErrorResponse
import com.kongjak.cloudflaremanager.data.model.zone.common.ResultResponse
import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.ZoneList

data class ZoneListResponse(
    override val errors: List<ErrorResponse>,
    override val messages: List<Any>,
    override val result: List<ResultResponse>?,
    @SerializedName("result_info")
    override val resultInfo: ResultInfoResponse?,
    override val success: Boolean
) : ZoneList
