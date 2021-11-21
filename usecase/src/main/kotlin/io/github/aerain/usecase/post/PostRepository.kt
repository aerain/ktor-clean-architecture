package io.github.aerain.usecase.post

import kotlinx.coroutines.flow.Flow
import io.github.aerain.entity.post.Post

private const val DEFAULT_OFFSET: Long = 0
private const val DEFAULT_PAGE_SIZE = 20
interface PostRepository {
    suspend fun findAll(offset: Long = DEFAULT_OFFSET, size: Int = DEFAULT_PAGE_SIZE): List<Post>
    suspend fun findById(id: Long): Post?
    suspend fun save(post: Post): Post
}