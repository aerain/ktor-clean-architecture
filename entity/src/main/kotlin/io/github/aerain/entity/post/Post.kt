package io.github.aerain.entity.post

import java.time.Instant

class Post(
    val id: Long = 0,
    title: String,
    val author: String,
    val postAt: Instant
) {
    var title = title
        private set

    fun changeTitle(title: String) {
        this.title = title
    }
}