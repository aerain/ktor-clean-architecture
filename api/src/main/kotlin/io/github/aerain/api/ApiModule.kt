package io.github.aerain.api

import io.github.aerain.api.v1.auth.AuthApi
import io.github.aerain.api.v1.post.PostApi
import io.github.aerain.api.v1.profile.ProfileApi
import org.koin.core.definition.Definition
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val apiModules = listOf(module(createdAtStart = true) {
    registerApi { AuthApi(get()) }
    registerApi { PostApi(get(), get(), get(), get(), get()) }
    registerApi { ProfileApi() }
})

private inline fun <reified T : Api> Module.registerApi(noinline definition: Definition<T>) =
    single<T>(definition = definition) bind Api::class
