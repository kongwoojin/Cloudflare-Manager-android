package com.kongjak.cloudflaremanager.domain.usecase

import com.kongjak.cloudflaremanager.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserEmailUseCase @Inject constructor(private val userRepository: UserRepository) {
    fun invoke(): Flow<String> {
        return userRepository.getUserEmail()
    }
}