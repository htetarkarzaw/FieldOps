package org.billie.plugins

import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.billie.routes.healthRoutes
import org.billie.routes.helloRoutes
import org.billie.routes.reportRoutes

fun Application.configureRouting() {
    routing {
        healthRoutes()
        helloRoutes()
        reportRoutes()
    }
}