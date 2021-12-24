package io.github.aerain.plugins

import com.auth0.jwt.interfaces.JWTVerifier
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import org.koin.ktor.ext.get

fun Application.configureAuthentication() {
    install(Authentication) {
        jwt {
            val verifier = get<JWTVerifier>()
            verifier(verifier)
            validate { credential -> JWTPrincipal(credential.payload) }
        }
    }
}