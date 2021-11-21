package io.github.aerain.entity.post

import java.time.Instant

data class Post(
    val id: Long = 0,
    val title: String,
    val author: String,
    val postAt: Instant
)