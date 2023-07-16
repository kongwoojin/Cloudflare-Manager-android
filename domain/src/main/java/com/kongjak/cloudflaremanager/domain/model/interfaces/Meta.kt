package com.kongjak.cloudflaremanager.domain.model.interfaces

interface Meta{
    val customCertificateQuota: Int
    val multipleRailgunsAllowed: Boolean
    val pageRuleQuota: Int
    val phishingDetected: Boolean
    val step: Int
}