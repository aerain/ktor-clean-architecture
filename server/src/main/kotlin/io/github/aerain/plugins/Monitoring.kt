package io.github.aerain.plugins

import io.ktor.features.*
import io.micrometer.prometheus.*
import io.ktor.metrics.micrometer.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
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
