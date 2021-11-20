package io.github.aerain.factory

import io.github.aerain.Api
import io.github.aerain.factory
import io.github.aerain.post.GetPostUseCase
import io.github.aerain.v1.PostApi
import org.koin.dsl.bind

val postFactory = factory {
    single<PostApi> { PostApi(get()) } bind Api::class
    single<GetPostUseCase> { GetPostUseCase() }
}