package org.billie.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.http.*
import io.ktor.server.plugins.statuspages.StatusPages
import kotlinx.serialization.Serializable
import org.billie.config.AppConfig

@Serializable
data class ErrorResponse(val error: String)


fun Application.configureStatusPages(config: AppConfig) {
    install(StatusPages) {
        exception<IllegalArgumentException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, ErrorResponse(cause.message ?: "Invalid request"))
        }
        exception<Throwable> { call, cause ->
            val message = if (config.isDev) {
                // dev: show message to help debugging
                cause.message ?: "Internal server error"
            } else {
                // prod: don’t leak internal details
                "Internal server error"
            }
            call.respond(HttpStatusCode.InternalServerError, ErrorResponse(message))
        }
    }
}