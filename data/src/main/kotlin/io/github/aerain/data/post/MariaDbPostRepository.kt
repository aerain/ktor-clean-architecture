package io.github.aerain.data.post

import io.github.aerain.entity.post.Post
import io.github.aerain.usecase.post.PostRepository
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class MariaDbPostRepository : PostRepository {
    override suspend fun findAll(offset: Long, size: Int) = Posts
        .selectAll()
        .limit(size, offset)
        .asFlow()
        .map { it.toEntity() }

    override suspend fun findById(id: Long) = Posts
        .select { Posts.id.eq(id) }
        .singleOrNull()?.toEntity()

    private fun ResultRow.toEntity() = Post(
        this[Posts.id].value,
        this[Posts.title],
        this[Posts.author],
        this[Posts.postAt]
    )
    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
    }
}