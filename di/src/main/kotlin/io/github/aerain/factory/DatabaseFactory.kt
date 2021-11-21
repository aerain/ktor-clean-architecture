package io.github.aerain.factory

import io.github.aerain.data.config.DatabaseConfig
import io.github.aerain.factory

val databaseFactory = factory {
    single { DatabaseConfig.dataSource() }
}