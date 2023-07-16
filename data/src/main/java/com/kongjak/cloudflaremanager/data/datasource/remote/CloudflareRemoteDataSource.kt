package com.kongjak.cloudflaremanager.data.datasource.remote

import com.google.gson.Gson
import com.kongjak.cloudflaremanager.data.api.API
import com.kongjak.cloudflaremanager.data.model.user.verify.VerifyResponse
import com.kongjak.cloudflaremanager.data.model.ZonesResponse
import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Verify
import com.kongjak.cloudflaremanager.domain.model.interfaces.Zones
import javax.inject.Inject

class CloudflareRemoteDataSource @Inject constructor(private val api: API) {
    suspend fun verifyToken(token: String): Verify {
        val response = api.getZones("Bearer $token")
        val gson = Gson()

        return if (response.isSuccessful) {
            gson.fromJson(gson.toJson(response.body()), VerifyResponse::class.java)
        } else {
            gson.fromJson(response.errorBody()?.string(), VerifyResponse::class.java)
        }
    }

    suspend fun getZones(token: String): Zones {
        val response = api.getZones("Bearer $token")
        val gson = Gson()

        return if (response.isSuccessful) {
            gson.fromJson(gson.toJson(response.body()), ZonesResponse::class.java)
        } else {
            gson.fromJson(response.errorBody()?.string(), ZonesResponse::class.java)
        }
    }
}