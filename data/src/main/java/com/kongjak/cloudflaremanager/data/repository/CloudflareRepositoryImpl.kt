package com.kongjak.cloudflaremanager.data.repository

import android.util.Log
import com.kongjak.cloudflaremanager.data.datasource.remote.CloudflareRemoteDataSource
import com.kongjak.cloudflaremanager.domain.repository.CloudflareRepository
import javax.inject.Inject

class CloudflareRepositoryImpl @Inject constructor(private val cloudflareRemoteDataSource: CloudflareRemoteDataSource): CloudflareRepository {
    override suspend fun getZones(email: String, apiKey: String) {
        val test = cloudflareRemoteDataSource.getZones(email, apiKey)
        Log.d("Test", test.toString())
    }
}