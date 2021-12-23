package io.github.aerain.data.config

import java.time.Duration

data class JwtConfig(
    val secret: String,
    val issuer: String,
    val audience: String,
    val expireMilliseconds: Long
) {
    val expireDuration: Duration = Duration.ofMillis(expireMilliseconds)
}
