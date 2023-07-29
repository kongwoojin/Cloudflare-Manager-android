package com.kongjak.cloudflaremanager.data.model.zone.common

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common.Account

data class AccountResponse(
    override val id: String,
    override val name: String
) : Account
