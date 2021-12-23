package io.github.aerain.factory

import io.github.aerain.data.config.DataSourceProperties
import io.github.aerain.data.config.JwtConfig
import io.github.aerain.factory
import io.ktor.application.*
import org.koin.core.KoinApplication

fun Application.registerPropertyConfig(koin: KoinApplication) {
    val dataSourceConfig = dataSourceConfig()
    val jwtConfig = jwtConfig()

    koin.modules(factory {
        single { dataSourceConfig }
        single { jwtConfig }
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

fun Application.jwtConfig(): JwtConfig {
    val config = environment.config
    return JwtConfig(
        config.property("jwt.secret").getString(),
        config.property("jwt.issuer").getString(),
        config.property("jwt.audience").getString(),
        config.property("jwt.expire-milliseconds").getString().toLong(),
    )
}

