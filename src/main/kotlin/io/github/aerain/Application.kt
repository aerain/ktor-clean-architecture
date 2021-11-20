package io.github.aerain

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.github.aerain.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }.start(wait = true)
}
