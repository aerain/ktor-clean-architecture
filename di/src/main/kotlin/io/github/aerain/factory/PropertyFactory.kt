package io.github.aerain.factory

import io.github.aerain.data.config.DataSourceProperties
import io.github.aerain.factory
import io.ktor.application.*
import org.koin.core.KoinApplication

fun Application.registerPropertyConfig(koin: KoinApplication) {
    val dataSourceConfig = dataSourceConfig()
    koin.modules(factory {
        single { dataSourceConfig }
    })
}

fun Application.dataSourceConfig(): DataSourceProperties {
    val config = environment.config
    return DataSourceProperties(
        config.property("exposed.data-source.url").getString(),
        config.property("exposed.data-source.driver").getString(),
        config.property("exposed.data-source.username").getString(),
        config.property("exposed.data-source.password").getString(),
        config.property("exposed.data-source.connection-pool-size").getString().toInt()
    )
}

