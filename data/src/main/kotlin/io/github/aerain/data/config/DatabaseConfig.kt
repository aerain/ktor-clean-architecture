package io.github.aerain.data.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.slf4j.LoggerFactory
import javax.sql.DataSource
import kotlin.reflect.jvm.jvmName

object DatabaseConfig {
    private val logger = LoggerFactory.getLogger(this::class.jvmName)

    fun connect() {
        logger.info("start connect database")
        val dataSource = dataSource()
        Database.connect(dataSource)
    }

    private fun dataSource(): DataSource =
        HikariConfig().apply {
            driverClassName = "org.mariadb.jdbc.Driver"
            jdbcUrl = "jdbc:mariadb://127.0.0.1:3306/post"
            username = "root"
            password = ""
            maximumPoolSize = 5
        }.let(::HikariDataSource)
}
