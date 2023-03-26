package com.hungrytech.util

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    val issuer: String,
    val subject: String,
    val expiresTime: Long,
    val secret: String
) {
}
