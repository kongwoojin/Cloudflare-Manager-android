package com.kongjak.cloudflaremanager.domain.model.interfaces

interface ResultInfo{
    val count: Int
    val page: Int
    val perPage: Int
    val totalCount: Int
    val totalPages: Int
}