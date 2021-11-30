package io.github.aerain.data.post

import io.github.aerain.usecase.post.DeletePostUseCase
import io.github.aerain.usecase.post.PostRepository
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class TransactionalDeletePostUseCase(
    repository: PostRepository
): DeletePostUseCase(repository) {
    override suspend fun invoke(id: Long) = newSuspendedTransaction {
        super.invoke(id)
    }
}