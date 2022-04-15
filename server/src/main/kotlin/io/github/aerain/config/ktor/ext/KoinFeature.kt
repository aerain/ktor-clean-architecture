package io.github.aerain.config.ktor.ext

import io.ktor.server.application.*
import io.ktor.util.*
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

// TODO if koin-ktor officially support ktor 2.0, it should be deleted.
class Koin(internal val koinApplication: KoinApplication) {
    companion object KoinPlugin: Plugin<Application, KoinApplication, Koin> {
        override val key: AttributeKey<Koin>
            get() = AttributeKey<Koin>("Koin")

        override fun install(pipeline: Application, configure: KoinApplication.() -> Unit): Koin {
            val monitor = pipeline.environment.monitor

            val koinApplication = startKoin(appDeclaration = configure)
            monitor.raise(KoinApplicationStarted, koinApplication)

            monitor.subscribe(ApplicationStopped) {
                monitor.raise(KoinApplicationStopPreparing, koinApplication)
                stopKoin()
                monitor.raise(KoinApplicationStopped, koinApplication)
            }
            return Koin(koinApplication)
        }
    }
}