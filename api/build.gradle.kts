val ktor_version: String by project
val jackson_version: String by project

fun ktor(module: String) = "io.ktor:ktor-$module:$ktor_version"
dependencies {
    api(project(":usecase"))

    implementation(ktor("auth"))
    implementation(ktor("auth-jwt"))
    implementation(ktor("server-core"))
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson_version")
}