package org.billie.models

import kotlinx.serialization.Serializable

@Serializable
data class CreateReportRequest(
    val title: String,
    val note: String? = null
)

@Serializable
data class ReportResponse(
    val id: String,
    val title: String,
    val note: String? = null
)