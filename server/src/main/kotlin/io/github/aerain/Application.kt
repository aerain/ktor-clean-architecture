package io.github.aerain

import io.github.aerain.plugins.*
import io.ktor.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    installKoinModule()
    configureAuthentication()
    configureRouting()
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureDatabase()
    configureExceptionHandler()
}