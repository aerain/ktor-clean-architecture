package io.github.aerain.factory

import com.auth0.jwt.interfaces.JWTVerifier
import io.github.aerain.data.token.SharedSecretTokenManager
import io.github.aerain.factory
import io.github.aerain.usecase.token.TokenProvider
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.binds

val tokenFactory = factory {
    single { SharedSecretTokenManager(get(), Dispatchers.Default) }
        .binds(arrayOf(JWTVerifier::class, TokenProvider::class))
}