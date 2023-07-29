package com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.Result

interface ZoneList {
    val errors: List<Error>
    val messages: List<Any>
    val result: List<Result>?
    val resultInfo: ResultInfo?
    val success: Boolean
}
