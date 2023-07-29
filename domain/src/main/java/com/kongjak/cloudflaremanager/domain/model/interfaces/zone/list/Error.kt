package com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list

interface Error {
    val code: Int
    val errorChain: List<ErrorChain>
    val message: String
}
