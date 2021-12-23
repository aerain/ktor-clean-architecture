package io.github.aerain.api.v1.auth

import com.fasterxml.jackson.annotation.JsonCreator
import io.github.aerain.api.Api
import io.github.aerain.usecase.token.Context
import io.github.aerain.usecase.token.IssueTokenUseCase
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

class AuthApi(
    val issueToken: IssueTokenUseCase
): Api({
    // dummy login api for issue token
    post("/login") {
        val request = call.receive<LoginRequest>()
        call.respond(issueToken(Context(request.username)))
    }
})

data class LoginRequest @JsonCreator constructor(
    val username: String,
    val password: String
)