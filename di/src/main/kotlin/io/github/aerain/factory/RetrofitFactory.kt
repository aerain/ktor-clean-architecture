package io.github.aerain.factory

import io.github.aerain.data.config.retrofit.RetrofitFactory
import io.github.aerain.factory

val retrofitFactory = factory {
    single { RetrofitFactory.retrofit() }
}