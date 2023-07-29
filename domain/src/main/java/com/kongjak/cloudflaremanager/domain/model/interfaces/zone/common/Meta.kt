package com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common

interface Meta {
    val customCertificateQuota: Int
    val multipleRailgunsAllowed: Boolean
    val pageRuleQuota: Int
    val phishingDetected: Boolean
    val step: Int
}
