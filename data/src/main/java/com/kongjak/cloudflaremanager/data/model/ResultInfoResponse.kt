package com.kongjak.cloudflaremanager.data.model

import com.google.gson.annotations.SerializedName
import com.kongjak.cloudflaremanager.domain.model.interfaces.ResultInfo

data class ResultInfoResponse(
    override val count: Int,
    override val page: Int,
    @SerializedName("per_page")
    override val perPage: Int,
    @SerializedName("total_count")
    override val totalCount: Int,
    @SerializedName("total_pages")
    override val totalPages: Int
) : ResultInfo
