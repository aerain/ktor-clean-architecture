package io.github.aerain.data.weather

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val weatherModule = module(createdAtStart = true) {
    single {
        val retrofit by inject<Retrofit>()
        retrofit.create<WeatherApi>()
    }
}