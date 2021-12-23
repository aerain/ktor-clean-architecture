package io.github.aerain.factory

import io.github.aerain.api.Api
import io.github.aerain.api.v1.profile.ProfileApi
import io.github.aerain.factory
import org.koin.dsl.bind

val profileFactory = factory {
    single { ProfileApi() } bind Api::class
}