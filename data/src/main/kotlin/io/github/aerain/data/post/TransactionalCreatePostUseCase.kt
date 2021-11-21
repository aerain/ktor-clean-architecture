package io.github.aerain.data.post

import io.github.aerain.usecase.post.CreatePostRequest
import io.github.aerain.usecase.post.CreatePostUseCase
import io.github.aerain.usecase.post.Post
import io.github.aerain.usecase.post.PostRepository
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class TransactionalCreatePostUseCase(repository: PostRepository): CreatePostUseCase(repository) {
    override suspend fun invoke(request: CreatePostRequest): Post = newSuspendedTransaction {
        super.invoke(request)
    }
}
