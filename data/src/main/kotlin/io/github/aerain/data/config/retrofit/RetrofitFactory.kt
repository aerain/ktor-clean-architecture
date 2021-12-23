package io.github.aerain.data.config.retrofit

import io.github.aerain.data.weather.WeatherApi
import retrofit2.Retrofit
import retrofit2.create

object RetrofitFactory {
    fun retrofit(): Retrofit = Retrofit.Builder()
        .validateEagerly(true)
        .baseUrl("http://example")
        .build()

    fun weatherApi(retrofit: Retrofit): WeatherApi = retrofit.create()
}