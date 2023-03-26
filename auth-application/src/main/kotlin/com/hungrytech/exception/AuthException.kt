package com.hungrytech.exception

sealed class AuthException(
    val code: ErrorCode,
    override val message: String
) : RuntimeException(message)

data class NotFoundException(
    override val message: String
) : AuthException(code = ErrorCode.NOT_FOUND, message = message)

data class UnAuthorizeException(
    override val message: String
) : AuthException(code = ErrorCode.UN_AUTHORIZE, message = message)



sealed class MemberException(
    code: ErrorCode,
    override val message: String
) : AuthException(code, message)

data class MemberExistsException(
    override val message: String = "이미 존재하는 유저입니다."
) : MemberException(ErrorCode.EXISTS, message)
