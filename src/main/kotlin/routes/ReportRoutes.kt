package org.billie.routes

import io.ktor.http.*
import io.ktor.server.application.call
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.billie.Repository.InMemoryReportRepository
import org.billie.Repository.ReportRepository
import org.billie.models.CreateReportRequest

private val repo: ReportRepository = InMemoryReportRepository()

fun Route.reportRoutes() {
    route("/reports") {
        post {
            val body = call.receive<CreateReportRequest>()
            val created = repo.create(body)
            call.respond(HttpStatusCode.Created, created)
        }

        get {
            call.respond(HttpStatusCode.OK, repo.list())
        }

        get("/{id}") {
            val id = call.parameters["id"] ?: throw IllegalArgumentException("id is required")
            val report = repo.get(id) ?: return@get call.respond(
                HttpStatusCode.NotFound,
                mapOf("error" to "Report not found")
            )
            call.respond(HttpStatusCode.OK, report)
        }
    }
}