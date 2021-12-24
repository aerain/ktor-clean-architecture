val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val prometeus_version: String by project
val coroutines_version: String by project
val koin_version: String by project
val java_sdk_version: String by project

plugins {
    kotlin("jvm") version "1.6.0"
}

allprojects {
    group = "io.github.aerain"
    version = "0.0.1"
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

    tasks {
        compileKotlin {
            kotlinOptions {
                jvmTarget = java_sdk_version
            }
        }
    }

    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}