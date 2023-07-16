package com.kongjak.cloudflaremanager.domain.usecase

import com.kongjak.cloudflaremanager.domain.model.interfaces.Zones
import com.kongjak.cloudflaremanager.domain.repository.CloudflareRepository
import javax.inject.Inject

class GetZonesUseCase @Inject constructor(private val cloudflareRepository: CloudflareRepository) {
    suspend operator fun invoke(token: String, page: Int): Zones {
        return cloudflareRepository.getZones(token, page)
    }
}
