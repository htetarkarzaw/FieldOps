package org.billie

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.application.*
import org.billie.config.AppConfig
import org.billie.config.loadConfig
import org.billie.plugins.configureLogging
import org.billie.plugins.configureRouting
import org.billie.plugins.configureSerialization
import org.billie.plugins.configureStatusPages

fun main() {
    val config = loadConfig()
    embeddedServer(
        factory = Netty,
        port = config.port,
        host = "0.0.0.0",
        module = {
            module(config)
        }
    ).start(wait = true)
}

fun Application.module(config: AppConfig = loadConfig()) {
    configureLogging()
    configureSerialization()
    configureStatusPages(config = config)
    configureRouting()
}
