package io.github.aerain.factory

import io.github.aerain.api.Api
import io.github.aerain.factory
import io.github.aerain.usecase.post.GetPostUseCase
import io.github.aerain.api.PostApi
import io.github.aerain.data.post.TransactionalGetPostUseCase
import org.koin.dsl.bind

val postFactory = factory {
    single<PostApi> { PostApi(get()) } bind Api::class
    single<GetPostUseCase> { TransactionalGetPostUseCase() }
}