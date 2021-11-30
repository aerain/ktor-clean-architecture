package io.github.aerain.factory

import io.github.aerain.api.Api
import io.github.aerain.api.v1.post.PostApi
import io.github.aerain.data.post.*
import io.github.aerain.factory
import io.github.aerain.usecase.post.*
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.bind

val postFactory = factory {
    single<PostApi> { PostApi(get(), get(), get(), get(), get()) } bind Api::class
    single<GetPostUseCase> { TransactionalGetPostUseCase(get(), Dispatchers.Default) }
    single<GetAllPostUseCase> { TransactionalGetAllPostUseCase(get(), Dispatchers.Default) }
    single<CreatePostUseCase> { TransactionalCreatePostUseCase(get(), Dispatchers.Default) }
    single<UpdatePostUseCase> { TransactionalUpdatePostUseCase(get(), Dispatchers.Default) }
    single<DeletePostUseCase> { TransactionalDeletePostUseCase(get(), Dispatchers.Default) }
    single<PostRepository> { MariaDbPostRepository(Dispatchers.IO) }
}