package org.billie.config

data class AppConfig(
    val port: Int,
    val env: String
) {
    val isDev: Boolean get() = env.equals("dev", ignoreCase = true)
}

fun loadConfig(): AppConfig {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 8080
    val env = System.getenv("APP_ENV") ?: "prod"
    return AppConfig(port = port, env = env)
}