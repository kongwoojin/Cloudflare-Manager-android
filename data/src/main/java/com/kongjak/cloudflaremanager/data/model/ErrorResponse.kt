package com.kongjak.cloudflaremanager.data.model

import com.google.gson.annotations.SerializedName
import com.kongjak.cloudflaremanager.domain.model.interfaces.Error

data class ErrorResponse(
    override val code: Int,
    @SerializedName("error_chain")
    override val errorChain: List<ErrorChainResponse>,
    override val message: String
): Error