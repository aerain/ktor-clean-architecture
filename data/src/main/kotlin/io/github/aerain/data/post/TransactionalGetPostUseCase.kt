package io.github.aerain.data.post

import io.github.aerain.usecase.post.GetPostUseCase
import io.github.aerain.usecase.post.Post
import io.github.aerain.usecase.post.PostRepository
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class TransactionalGetPostUseCase(repository: PostRepository): GetPostUseCase(repository) {
    override suspend fun invoke(id: Long) = newSuspendedTransaction { super.invoke(id) }
}