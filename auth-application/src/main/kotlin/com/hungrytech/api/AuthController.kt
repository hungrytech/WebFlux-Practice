package com.hungrytech.api

import com.hungrytech.model.SignUpRequest
import com.hungrytech.usecase.AuthUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class AuthController(
    private val authUseCase: AuthUseCase
) {

    @PostMapping("/signup")
    suspend fun signUp(@RequestBody request: SignUpRequest) {
        authUseCase.signUp(request)
    }
}
