val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val prometeus_version: String by project
val jackson_version: String by project
val koin_version: String by project

plugins {
    application
    kotlin("jvm")
}

fun ktor(module: String) = "io.ktor:ktor-$module:$ktor_version"
fun ktorServer(module: String) = ktor("server-$module")
fun koin(module: String) = "io.insert-koin:koin-$module:$koin_version"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    api(project(":api"))
    api(project(":data"))

    implementation(ktorServer("core"))
    implementation(ktorServer("metrics-micrometer"))
    implementation(ktorServer("metrics"))
    implementation(ktorServer("netty"))
    implementation(ktorServer("auth"))
    implementation(ktorServer("auth-jwt"))
    implementation(ktorServer("content-negotiation"))
    implementation(ktorServer("status-pages"))
    implementation(ktorServer("cors"))
    implementation(ktor("serialization-jackson"))
    implementation("io.micrometer:micrometer-registry-prometheus:$prometeus_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    // jackson
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jackson_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")

    implementation("com.auth0:java-jwt:3.18.2")

    // koin
    implementation(koin("ktor"))
    implementation(koin("logger-slf4j"))
    testImplementation(koin("test"))

}