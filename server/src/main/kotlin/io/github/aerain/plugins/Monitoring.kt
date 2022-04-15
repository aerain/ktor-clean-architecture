package io.github.aerain.plugins

import io.github.aerain.config.ktor.ext.inject
import io.ktor.server.application.*
import io.ktor.server.metrics.micrometer.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.micrometer.prometheus.PrometheusMeterRegistry
import org.koin.ktor.ext.inject

fun Application.configureMonitoring() {
    val appMicrometerRegistry by inject<PrometheusMeterRegistry>()

    install(MicrometerMetrics) {
        registry = appMicrometerRegistry
    }

    routing {
        get("/metrics/prometheus") {
            call.respond(appMicrometerRegistry.scrape())
        }
    }
}
