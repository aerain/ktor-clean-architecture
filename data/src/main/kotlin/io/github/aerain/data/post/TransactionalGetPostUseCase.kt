package io.github.aerain.data.post

import io.github.aerain.usecase.post.GetPostUseCase
import io.github.aerain.usecase.post.Post
import org.jetbrains.exposed.sql.transactions.transaction

class TransactionalGetPostUseCase: GetPostUseCase() {
    override fun invoke() = transaction { super.invoke() }
}