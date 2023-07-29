package com.kongjak.cloudflaremanager.domain.model.interfaces.zone.detail

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.Result

interface ZoneDetail {
    val errors: List<Error>
    val messages: List<Any>
    val result: Result
    val success: Boolean
}
