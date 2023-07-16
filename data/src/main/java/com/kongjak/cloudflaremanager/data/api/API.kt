package com.kongjak.cloudflaremanager.data.api

import com.kongjak.cloudflaremanager.data.AUTHORIZATION
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface API {

    @GET("user/tokens/verify")
    suspend fun verifyToken(
        @Header(AUTHORIZATION) token: String
    ): Response<Any>

    @GET("zones")
    suspend fun getZones(
        @Header(AUTHORIZATION) token: String
    ): Response<Any>
}
