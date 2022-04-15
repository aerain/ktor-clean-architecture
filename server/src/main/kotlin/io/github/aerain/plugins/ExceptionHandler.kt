package io.github.aerain.plugins

import io.github.aerain.api.exception.exceptionHandler
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*

fun Application.configureExceptionHandler() {
    install(StatusPages) {
        exceptionHandler()
    }
}