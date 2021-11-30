package io.github.aerain.factory

import io.github.aerain.api.Api
import io.github.aerain.factory
import io.github.aerain.api.v1.post.PostApi
import io.github.aerain.data.post.*
import io.github.aerain.usecase.post.*
import org.koin.dsl.bind

val postFactory = factory {
    single<PostApi> { PostApi(get(), get(), get(), get()) } bind Api::class
    single<GetPostUseCase> { TransactionalGetPostUseCase(get()) }
    single<GetAllPostUseCase> { TransactionalGetAllPostUseCase(get()) }
    single<CreatePostUseCase> { TransactionalCreatePostUseCase(get()) }
    single<DeletePostUseCase> { TransactionalDeletePostUseCase(get()) }
    single<PostRepository> { MariaDbPostRepository() }
}