package io.github.aerain.api.v1.profile

import io.github.aerain.api.Api
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.response.*
import io.ktor.routing.*

class ProfileApi: Api({
    route("/profile") {
        authenticate {
            get("/my") {
                val principal = call.principal<JWTPrincipal>()!!
                val username = principal.payload.getClaim("username").asString()
                call.respond(ProfileResponse(username))
            }
        }
    }
})

data class ProfileResponse(
    val username: String
)