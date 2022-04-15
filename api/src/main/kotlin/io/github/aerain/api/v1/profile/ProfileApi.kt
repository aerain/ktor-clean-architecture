package io.github.aerain.api.v1.profile

import io.github.aerain.api.Api
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

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