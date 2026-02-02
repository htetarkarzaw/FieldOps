package org.billie.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.helloRoutes() {
    get("/hello") {
        val name = call.request.queryParameters["name"]?.takeIf { it.isNotBlank() } ?: "world"
        call.respond(HttpStatusCode.OK, mapOf("message" to "Hello, $name!"))
    }
}