package com.kongjak.cloudflaremanager.domain.usecase

import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Verify
import com.kongjak.cloudflaremanager.domain.repository.CloudflareRepository
import javax.inject.Inject

class VerifyTokenUseCase @Inject constructor(private val cloudflareRepository: CloudflareRepository) {
    suspend operator fun invoke(token: String): Verify {
        return cloudflareRepository.verifyToken(token)
    }
}