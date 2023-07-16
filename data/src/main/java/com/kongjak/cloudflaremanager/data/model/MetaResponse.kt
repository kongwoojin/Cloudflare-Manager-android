package com.kongjak.cloudflaremanager.data.model

import com.google.gson.annotations.SerializedName
import com.kongjak.cloudflaremanager.domain.model.interfaces.Meta

data class MetaResponse(
    @SerializedName("custom_certificate_quota")
    override val customCertificateQuota: Int,
    @SerializedName("multiple_railguns_allowed")
    override val multipleRailgunsAllowed: Boolean,
    @SerializedName("page_rule_quota")
    override val pageRuleQuota: Int,
    @SerializedName("phishing_detected")
    override val phishingDetected: Boolean,
    override val step: Int
) : Meta
