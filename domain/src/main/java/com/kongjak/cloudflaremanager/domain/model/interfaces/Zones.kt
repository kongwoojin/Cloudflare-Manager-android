package com.kongjak.cloudflaremanager.domain.model.interfaces

interface Zones {
    val errors: List<Error>
    val messages: List<Any>
    val result: List<Result>?
    val resultInfo: ResultInfo?
    val success: Boolean
}
