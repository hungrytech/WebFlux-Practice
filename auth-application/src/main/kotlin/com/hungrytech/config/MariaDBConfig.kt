package com.hungrytech.config

import io.r2dbc.spi.ConnectionFactory
import org.mariadb.r2dbc.MariadbConnectionConfiguration
import org.mariadb.r2dbc.MariadbConnectionFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.r2dbc.connection.R2dbcTransactionManager


@Configuration
class MariaDBConfig {

    @Bean
    fun mariaDBConnectionFactory(r2dbcRepositories: R2DBCProperties): ConnectionFactory =
        MariadbConnectionFactory(
            MariadbConnectionConfiguration.builder()
                .host(r2dbcRepositories.host)
                .port(r2dbcRepositories.port)
                .username(r2dbcRepositories.username)
                .password(r2dbcRepositories.password)
                .database(r2dbcRepositories.database)
                .allowPublicKeyRetrieval(true)
                .build()
        )

    @Bean
    @Primary
    fun reactiveTransactionManager(@Qualifier("mariaDBConnectionFactory") connectionFactory: ConnectionFactory) =
        R2dbcTransactionManager(connectionFactory)
}
