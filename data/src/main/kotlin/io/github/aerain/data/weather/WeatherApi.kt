package io.github.aerain.data.weather

import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("/weathers/{region}")
    fun findByRegion(@Path("region") region: String)
}