package io.github.aerain.plugins

import io.github.aerain.api.apiModules
import io.github.aerain.config.serverModules
import io.github.aerain.data.dataModules
import io.ktor.application.*
import org.koin.ktor.ext.*
import org.koin.logger.SLF4JLogger

fun Application.installKoinModule() {
    environment.monitor.subscribe(KoinApplicationStarted) {
        log.info("Koin container started.")
    }
    install(Koin) {
        SLF4JLogger()
        registerPropertyConfig(this)
        modules(modules)
    }
    environment.monitor.subscribe(KoinApplicationStopPreparing) {
        log.info("Koin stopping...")
    }
    environment.monitor.subscribe(KoinApplicationStopped) {
        log.info("Koin stopped.")
    }
}

val modules = listOf(
    apiModules,
    dataModules,
    serverModules
).flatten()