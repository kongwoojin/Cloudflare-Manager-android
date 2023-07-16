package com.kongjak.cloudflaremanager.data.api

import com.kongjak.cloudflaremanager.data.AUTHORIZATION
import com.kongjak.cloudflaremanager.data.PAGE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface API {

    @GET("user/tokens/verify")
    suspend fun verifyToken(
        @Header(AUTHORIZATION) token: String
    ): Response<Any>

    @GET("zones")
    suspend fun getZones(
        @Header(AUTHORIZATION) token: String,
        @Query(PAGE) page: Int
    ): Response<Any>
}
