package io.github.aerain.plugins

import io.ktor.application.*
import io.ktor.metrics.micrometer.*
import io.ktor.response.*
import io.ktor.routing.*
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
