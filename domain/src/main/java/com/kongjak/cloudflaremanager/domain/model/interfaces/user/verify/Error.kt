package com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify

interface Error {
    val code: Int
    val errorChain: List<ErrorChain>
    val message: String
}
