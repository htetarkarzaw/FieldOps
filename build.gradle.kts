plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "2.0.21"
    application
}

group = "org.billie"
version = "0.0.1"

repositories {
    mavenCentral()
}

val ktorVersion = "2.3.12"
val logbackVersion = "1.5.13"

dependencies {

    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")

    // JSON
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")

    // Logging
    implementation("io.ktor:ktor-server-call-logging-jvm:${ktorVersion}")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // Error handling
    implementation("io.ktor:ktor-server-status-pages-jvm:${ktorVersion}")

    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-test-host-jvm:${ktorVersion}")
}



kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

application {
    // We'll create this class next
    mainClass.set("org.billie.ApplicationKt")
}