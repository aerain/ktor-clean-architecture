package io.github.aerain.data.config

import org.koin.dsl.module
import retrofit2.Retrofit

val retrofitModule = module(createdAtStart = true) {
    single<Retrofit> {
        Retrofit.Builder()
            .validateEagerly(true)
            .baseUrl("http://example")
            .build()
    }
}