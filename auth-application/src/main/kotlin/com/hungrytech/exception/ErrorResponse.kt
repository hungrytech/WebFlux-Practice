package com.hungrytech.exception

data class ErrorResponse(
    val code: ErrorCode,
    val message: String,
)
