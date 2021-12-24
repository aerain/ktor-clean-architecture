package io.github.aerain.data.token

import com.auth0.jwt.interfaces.JWTVerifier
import io.github.aerain.usecase.token.IssueTokenUseCase
import io.github.aerain.usecase.token.TokenProvider
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.binds
import org.koin.dsl.module

val tokenModule = module(createdAtStart = true) {
    single { SharedSecretTokenManager(get(), Dispatchers.Default) }
        .binds(arrayOf(JWTVerifier::class, TokenProvider::class))

    single { IssueTokenUseCase(get()) }
}