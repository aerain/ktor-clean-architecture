package io.github.aerain.factory

import io.github.aerain.api.Api
import io.github.aerain.api.v1.auth.AuthApi
import io.github.aerain.factory
import io.github.aerain.usecase.token.IssueTokenUseCase
import org.koin.dsl.bind

val authFactory = factory {
    single { AuthApi(get()) } bind Api::class
    single { IssueTokenUseCase(get()) }
}