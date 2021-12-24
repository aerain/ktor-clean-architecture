package io.github.aerain.data.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.koin.dsl.module
import javax.sql.DataSource

val databaseModule = module(createdAtStart = true) {
    single {
        val dataSource = get<DataSource>()
        logger.info("start connect database: $dataSource")
        Database.connect(dataSource)
    }

    single<DataSource> {
        val properties = get<DataSourceProperties>()
        HikariConfig().apply {
            driverClassName = properties.driver
            jdbcUrl = properties.url
            username = properties.username
            password = properties.password
            maximumPoolSize = properties.connectionPoolSize
        }.let(::HikariDataSource)
    }
}