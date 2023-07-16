package com.kongjak.cloudflaremanager.data.api

import com.kongjak.cloudflaremanager.data.AUTHORIZATION
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface API {
    @GET("zones")
    suspend fun getZones(
        @Header("Authorization") token: String,
    ): Response<Any>
}