package com.kongjak.cloudflaremanager.domain.model.interfaces

interface Error {
    val code: Int
    val errorChain: List<ErrorChain>
    val message: String
}
