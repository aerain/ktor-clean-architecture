package io.github.aerain.factory

import io.github.aerain.factory
import io.github.aerain.post.GetPostUseCase
import io.github.aerain.v1.PostApi

val postFactory = factory {
    single<PostApi> { PostApi(get()) }
    single<GetPostUseCase> { GetPostUseCase() }
}