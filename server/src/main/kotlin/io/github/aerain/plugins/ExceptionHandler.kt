package io.github.aerain.plugins

import io.github.aerain.api.exception.exceptionHandler
import io.ktor.application.*
import io.ktor.features.*

fun Application.configureExceptionHandler() {
    install(StatusPages) {
        exceptionHandler()
    }
}