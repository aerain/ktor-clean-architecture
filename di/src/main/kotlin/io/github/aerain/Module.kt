package io.github.aerain

import io.github.aerain.api.Api
import io.github.aerain.data.config.DatabaseConfig
import io.github.aerain.factory.dataSourceConfig
import io.github.aerain.factory.databaseFactory
import io.github.aerain.factory.postFactory
import io.github.aerain.factory.registerPropertyConfig
import io.ktor.application.*
import org.koin.core.KoinApplication
import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.getKoin
import org.koin.ktor.ext.Koin
import org.koin.logger.SLF4JLogger
import javax.sql.DataSource

fun Application.installKoinModule() {
    install(Koin) {
        SLF4JLogger()
        registerPropertyConfig(this)
        modules(postFactory)
        modules(databaseFactory)
    }
}

fun factory(moduleDeclaration: ModuleDeclaration) = module(createdAtStart = true, moduleDeclaration)

val apis get() = getKoin().getAll<Api>().toSet()
val dataSources get() = getKoin().getAll<DataSource>().toSet()