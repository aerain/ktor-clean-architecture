package io.github.aerain.data.post

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp

object Posts : LongIdTable("post") {
    val title = varchar("title", 50)
    val author = varchar("author", 20)
    val postAt = timestamp("post_at")
}
