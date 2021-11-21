val kotlin_version: String by project

plugins {
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.0"
}

allOpen {
    annotation("io.github.aerain.usecase.UseCase")
}

dependencies {
    api(project(":entity"))
}