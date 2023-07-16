package com.kongjak.cloudflaremanager.domain.usecase

import com.kongjak.cloudflaremanager.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserTokenUseCase @Inject constructor(private val userRepository: UserRepository) {
    operator fun invoke(): String? {
        return userRepository.getUserToken()
    }
}