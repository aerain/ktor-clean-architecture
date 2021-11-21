package io.github.aerain.plugins

import io.github.aerain.data.config.DatabaseConfig
import io.github.aerain.dataSources
import io.ktor.application.*

fun Application.configureDatabase() {
    dataSources.forEach { DatabaseConfig.connect(it) }
}