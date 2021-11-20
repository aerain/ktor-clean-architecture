val koin_version: String by project
val ktor_version: String by project

dependencies {
    api(project(":api"))
    api(project(":usecase"))
    api(project(":data"))

    implementation("io.ktor:ktor-server-core:$ktor_version")
    // Koin Rest features
    testImplementation("io.insert-koin:koin-test:$koin_version")
    // Koin for Ktor
    implementation("io.insert-koin:koin-ktor:$koin_version")
    // SLF4J Logger
    implementation("io.insert-koin:koin-logger-slf4j:$koin_version")
}