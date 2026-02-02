package org.billie.Repository

import org.billie.models.CreateReportRequest
import org.billie.models.ReportResponse

interface ReportRepository {
    fun create(request: CreateReportRequest): ReportResponse
    fun get(id: String): ReportResponse?
    fun list(): List<ReportResponse>
}