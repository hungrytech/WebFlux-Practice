package com.hungrytech.util

import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration

@Configuration
class TestClass(
    private val jwtProperties: JwtProperties
) {


    @PostConstruct
    fun init() {
        println(jwtProperties.subject)
        println(jwtProperties.expiresTime)
    }
}
