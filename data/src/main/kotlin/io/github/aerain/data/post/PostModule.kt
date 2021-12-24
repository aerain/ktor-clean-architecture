package io.github.aerain.data.post

import io.github.aerain.usecase.post.*
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val postDataModule = module(createdAtStart = true) {
    single<PostRepository> { MariaDbPostRepository(Dispatchers.IO) }
    single<GetPostUseCase> { TransactionalGetPostUseCase(get(), Dispatchers.Default) }
    single<GetAllPostUseCase> { TransactionalGetAllPostUseCase(get(), Dispatchers.Default) }
    single<CreatePostUseCase> { TransactionalCreatePostUseCase(get(), Dispatchers.Default) }
    single<UpdatePostUseCase> { TransactionalUpdatePostUseCase(get(), Dispatchers.Default) }
    single<DeletePostUseCase> { TransactionalDeletePostUseCase(get(), Dispatchers.Default) }
}