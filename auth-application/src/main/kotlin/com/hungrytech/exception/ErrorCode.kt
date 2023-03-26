package com.hungrytech.exception

enum class ErrorCode(
    val num: Int
) {
    EXISTS(409),
    NOT_FOUND(404),
    UN_AUTHORIZE(401),
    SERVER_ERROR(500)
}
