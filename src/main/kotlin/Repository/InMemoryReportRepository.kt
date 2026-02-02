package org.billie.Repository

import org.billie.models.CreateReportRequest
import org.billie.models.ReportResponse
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

class InMemoryReportRepository : ReportRepository {
    private val store = ConcurrentHashMap<String, ReportResponse>()

    override fun create(request: CreateReportRequest): ReportResponse {
        require(request.title.isNotBlank()) { "title is required" }

        val id = UUID.randomUUID().toString()
        val report = ReportResponse(id = id, title = request.title.trim(), note = request.note?.trim())
        store[id] = report
        return report
    }

    override fun get(id: String): ReportResponse? = store[id]

    override fun list(): List<ReportResponse> = store.values.toList()
}