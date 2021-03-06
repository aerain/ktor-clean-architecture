package io.github.aerain.usecase.post

import java.time.Instant

data class Post(
    val id: Long,
    val title: String,
    val author: String,
    val postAt: Instant
)