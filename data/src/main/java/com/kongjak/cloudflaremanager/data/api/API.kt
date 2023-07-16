package com.kongjak.cloudflaremanager.data.api

import com.kongjak.cloudflaremanager.data.HEADER_EMAIL
import com.kongjak.cloudflaremanager.data.HEADER_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface API {
    @GET("zones")
    suspend fun getZones(
        @Header(HEADER_EMAIL) email: String,
        @Header(HEADER_KEY) apiKey: String
    ): Response<Any>
}