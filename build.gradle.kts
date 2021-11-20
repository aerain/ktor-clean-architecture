val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val prometeus_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.0"
}

allprojects {
    group = "io.github.aerain"
    version = "0.0.1"
}

application {
    mainClass.set("io.github.aerain.ApplicationKt")
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
    }

    val implementation by configurations
    val testImplementation by configurations

    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}