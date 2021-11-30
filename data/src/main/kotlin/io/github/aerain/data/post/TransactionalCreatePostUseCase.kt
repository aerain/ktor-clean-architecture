package io.github.aerain.data.post

import io.github.aerain.usecase.post.CreatePostRequest
import io.github.aerain.usecase.post.CreatePostUseCase
import io.github.aerain.usecase.post.Post
import io.github.aerain.usecase.post.PostRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class TransactionalCreatePostUseCase(
    repository: PostRepository,
    private val dispatcher: CoroutineDispatcher
): CreatePostUseCase(repository) {
    override suspend fun invoke(request: CreatePostRequest): Post = newSuspendedTransaction(dispatcher) {
        super.invoke(request)
    }
}
