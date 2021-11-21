package io.github.aerain.factory

import io.github.aerain.api.Api
import io.github.aerain.factory
import io.github.aerain.usecase.post.GetPostUseCase
import io.github.aerain.api.PostApi
import io.github.aerain.data.post.MariaDbPostRepository
import io.github.aerain.data.post.TransactionalGetPostUseCase
import io.github.aerain.usecase.post.PostRepository
import org.koin.dsl.bind

val postFactory = factory {
    single<PostApi> { PostApi(get()) } bind Api::class
    single<GetPostUseCase> { TransactionalGetPostUseCase(get()) }
    single<PostRepository> { MariaDbPostRepository() }
}