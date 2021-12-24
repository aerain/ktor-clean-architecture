package io.github.aerain.data

import io.github.aerain.data.config.databaseModule
import io.github.aerain.data.config.retrofitModule
import io.github.aerain.data.post.postDataModule
import io.github.aerain.data.token.tokenModule
import io.github.aerain.data.weather.weatherModule

val dataModules = listOf(
    databaseModule,
    postDataModule,
    tokenModule,
    retrofitModule,
    weatherModule
)