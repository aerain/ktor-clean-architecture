val ktor_version: String by project
val jackson_version: String by project
val koin_version: String by project

fun ktor(module: String) = "io.ktor:ktor-$module:$ktor_version"
fun ktorServer(module: String) = ktor("server-$module")
fun koin(module: String) = "io.insert-koin:koin-$module:$koin_version"

dependencies {
    api(project(":usecase"))

    implementation(ktorServer("auth"))
    implementation(ktorServer("auth-jwt"))
    implementation(ktorServer("core"))
    implementation(ktorServer("status-pages"))
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson_version")

    // koin
    implementation(koin("ktor"))
    implementation(koin("logger-slf4j"))
    testImplementation(koin("test"))
}