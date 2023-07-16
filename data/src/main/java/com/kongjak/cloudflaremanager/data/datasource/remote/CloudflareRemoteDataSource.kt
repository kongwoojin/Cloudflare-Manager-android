package com.kongjak.cloudflaremanager.data.datasource.remote

import com.google.gson.Gson
import com.kongjak.cloudflaremanager.data.api.API
import com.kongjak.cloudflaremanager.data.model.ZonesResponse
import com.kongjak.cloudflaremanager.domain.model.interfaces.Zones
import javax.inject.Inject

class CloudflareRemoteDataSource @Inject constructor(private val api: API) {
    suspend fun getZones(email: String, apiKey: String): Zones {
        val response = api.getZones(email, apiKey)
        val gson = Gson()

        return if (response.isSuccessful) {
            gson.fromJson(gson.toJson(response.body()), ZonesResponse::class.java)
        } else {
            gson.fromJson(response.errorBody()?.string(), ZonesResponse::class.java)
        }
    }
}