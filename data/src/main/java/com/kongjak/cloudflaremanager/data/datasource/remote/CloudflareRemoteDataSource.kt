package com.kongjak.cloudflaremanager.data.datasource.remote

import com.google.gson.Gson
import com.kongjak.cloudflaremanager.data.api.API
import com.kongjak.cloudflaremanager.data.model.user.verify.VerifyResponse
import com.kongjak.cloudflaremanager.data.model.zone.detail.ZoneDetailResponse
import com.kongjak.cloudflaremanager.data.model.zone.list.ZoneListResponse
import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Verify
import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.detail.ZoneDetail
import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.ZoneList
import javax.inject.Inject

class CloudflareRemoteDataSource @Inject constructor(private val api: API) {
    suspend fun verifyToken(token: String): Verify {
        val response = api.verifyToken("Bearer $token")
        val gson = Gson()

        return if (response.isSuccessful) {
            gson.fromJson(gson.toJson(response.body()), VerifyResponse::class.java)
        } else {
            gson.fromJson(response.errorBody()?.string(), VerifyResponse::class.java)
        }
    }

    suspend fun getZones(token: String, page: Int): ZoneList {
        val response = api.getZones("Bearer $token", page)
        val gson = Gson()

        return if (response.isSuccessful) {
            gson.fromJson(gson.toJson(response.body()), ZoneListResponse::class.java)
        } else {
            gson.fromJson(response.errorBody()?.string(), ZoneListResponse::class.java)
        }
    }

    suspend fun getZoneDetail(token: String, id: String): ZoneDetail {
        val response = api.getZoneDetail("Bearer $token", id)
        val gson = Gson()

        return if (response.isSuccessful) {
            gson.fromJson(gson.toJson(response.body()), ZoneDetailResponse::class.java)
        } else {
            gson.fromJson(response.errorBody()?.string(), ZoneDetailResponse::class.java)
        }
    }
}
