package io.github.aerain

import io.github.aerain.factory.postFactory
import io.ktor.application.*
import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.getKoin
import org.koin.ktor.ext.Koin

fun Application.installKoinModule() {
    install(Koin) {
        modules(postFactory)
    }
}

fun factory(moduleDeclaration: ModuleDeclaration) = module(createdAtStart = true, moduleDeclaration)

val apis get() = getKoin().getAll<Api>()