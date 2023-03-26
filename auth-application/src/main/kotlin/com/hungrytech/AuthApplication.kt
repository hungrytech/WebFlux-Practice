package com.hungrytech

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing

@SpringBootApplication
@ConfigurationPropertiesScan
//@EnableR2dbcAuditing
class AuthApplication

fun main(args: Array<String>) {
    runApplication<AuthApplication>(*args)
}
