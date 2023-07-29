package com.kongjak.cloudflaremanager.domain.usecase

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.detail.ZoneDetail
import com.kongjak.cloudflaremanager.domain.repository.CloudflareRepository
import javax.inject.Inject

class GetZoneDetailUseCase @Inject constructor(private val cloudflareRepository: CloudflareRepository) {
    suspend operator fun invoke(token: String, id: String): ZoneDetail {
        return cloudflareRepository.getZoneDetail(token, id)
    }
}