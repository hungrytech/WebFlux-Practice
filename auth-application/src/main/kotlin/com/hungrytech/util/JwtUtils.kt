package com.hungrytech.util

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import java.util.*


object JwtUtils {

    fun createToken(claim: JWTClaim, properties: JwtProperties) =
        JWT.create()
            .withIssuer(properties.issuer)
            .withSubject(properties.subject)
            .withIssuedAt(Date())
            .withExpiresAt(Date(Date().time + properties.expiresTime + 1000))
            .withClaim("userId", claim.userId)
            .withClaim("email", claim.email)
            .withClaim("password", claim.password)
            .withClaim("userName", claim.username)
            .sign(Algorithm.HMAC256(properties.secret))



    fun decodeToken(token: String, claim: JWTClaim, properties: JwtProperties): DecodedJWT {
        val algorithm: Algorithm = Algorithm.HMAC256(properties.secret)

        val jwtVerifier = JWT.require(algorithm)
            .withIssuer(properties.issuer)
            .build()

        return jwtVerifier.verify(token)
    }
}


data class JWTClaim(
    val userId: String,
    val email: String,
    val password: String,
    val username: String
)
