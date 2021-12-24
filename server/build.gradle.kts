val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val prometeus_version: String by project
val jackson_version: String by project
val java_sdk_version: String by project

plugins {
    application
    kotlin("jvm")
}

fun ktor(module: String) = "io.ktor:ktor-$module:$ktor_version"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    api(project(":api"))
    api(project(":data"))

    implementation(ktor("server-core"))
    implementation(ktor("metrics-micrometer"))
    implementation(ktor("metrics"))
    implementation(ktor("jackson"))
    implementation(ktor("server-netty"))
    implementation(ktor("auth"))
    implementation(ktor("auth-jwt"))
    implementation("io.micrometer:micrometer-registry-prometheus:$prometeus_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    // jackson
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jackson_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")

    implementation("com.auth0:java-jwt:3.18.2")
}