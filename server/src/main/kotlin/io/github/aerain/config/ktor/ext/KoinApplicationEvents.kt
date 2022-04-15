package io.github.aerain.config.ktor.ext

import io.ktor.events.*
import org.koin.core.KoinApplication

// TODO if koin-ktor officially support ktor 2.0, it should be deleted.

/**
 * Event definition for [KoinApplication] Started event
 */
val KoinApplicationStarted = EventDefinition<KoinApplication>()

/**
 * Event definition for an event that is fired when the [KoinApplication] is going to stop
 */
val KoinApplicationStopPreparing = EventDefinition<KoinApplication>()

/**
 * Event definition for [KoinApplication] Stopping event
 */
val KoinApplicationStopped = EventDefinition<KoinApplication>()