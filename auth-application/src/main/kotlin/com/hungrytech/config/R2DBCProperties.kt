package com.hungrytech.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "r2dbc")
data class R2DBCProperties(
    val host: String,
    val port: Int,
    val username: String,
    val password: String,
    val database: String
) {
}
