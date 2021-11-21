package io.github.aerain

import io.github.aerain.api.Api
import io.github.aerain.data.post.config.DatabaseConfig
import io.github.aerain.factory.postFactory
import io.ktor.application.*
import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.getKoin
import org.koin.ktor.ext.Koin
import org.koin.logger.SLF4JLogger

fun Application.installKoinModule() {
    install(Koin) {
        SLF4JLogger()
        modules(postFactory)
    }
}

fun Application.configureDatabase() {
    DatabaseConfig.connect()
}

fun factory(moduleDeclaration: ModuleDeclaration) = module(createdAtStart = true, moduleDeclaration)

val apis: Set<Api> get() = getKoin().getAll<Api>().toSet()