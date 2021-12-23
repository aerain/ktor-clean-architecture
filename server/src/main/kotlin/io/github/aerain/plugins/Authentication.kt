package io.github.aerain.plugins

import com.auth0.jwt.interfaces.JWTVerifier
import io.github.aerain.getRegisteredInstance
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*

fun Application.configureAuthentication() {
    install(Authentication) {
        jwt {
            val verifier = getRegisteredInstance<JWTVerifier>()
            verifier(verifier)
            validate { credential -> JWTPrincipal(credential.payload) }
        }
    }
}