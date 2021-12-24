package io.github.aerain.config

import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import org.koin.dsl.module

val meterRegistryModule = module(createdAtStart = true) {
    single { PrometheusMeterRegistry(PrometheusConfig.DEFAULT) }
}

val serverModules = listOf(
    meterRegistryModule
)