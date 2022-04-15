package io.github.aerain.config.ktor.ext

import org.koin.core.context.GlobalContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

// TODO if koin-ktor officially support 2.0, it should be deleted
inline fun <reified T: Any> inject(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
) = lazy { get<T>(qualifier, parameters) }

inline fun <reified T : Any> get(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null,
): T = koin.get<T>(qualifier, parameters)

val koin = GlobalContext.get()