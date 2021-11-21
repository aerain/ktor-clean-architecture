package io.github.aerain.usecase.exception

class NotFoundException : BaseException {
    constructor(msg: String): super(msg)
    constructor(msg: String, cause: Throwable): super(msg, cause)
    constructor(cause: Throwable): super(cause)
}