package com.hungrytech.usecase

import com.hungrytech.domain.Member
import com.hungrytech.domain.MemberRepository
import com.hungrytech.exception.MemberExistsException
import com.hungrytech.model.SignUpRequest
import com.hungrytech.util.BCryptUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthUseCase(
    private val memberRepository: MemberRepository
) {


    @Transactional
    suspend fun signUp(signUpRequest: SignUpRequest) {
        with(signUpRequest) {
            memberRepository.findByEmail(email)?.let {
                throw MemberExistsException()
            }


            val member = Member(
                email = email,
                password = BCryptUtils.hash(password),
                username = username
            )

            memberRepository.save(member)
        }
    }
}
