package io.github.aerain.data.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.slf4j.LoggerFactory
import javax.sql.DataSource
import kotlin.reflect.jvm.jvmName

object DatabaseConfig {
    private val logger = LoggerFactory.getLogger(this::class.jvmName)

    fun connect(dataSource: DataSource) {
        logger.info("start connect database: {}", dataSource)
        Database.connect(dataSource)
    }

    fun dataSource(properties: DataSourceProperties): DataSource =
        HikariConfig().apply {
            driverClassName = properties.driver
            jdbcUrl = properties.url
            username = properties.username
            password = properties.password
            maximumPoolSize = properties.connectionPoolSize
        }.let(::HikariDataSource)
}
