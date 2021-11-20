val ktor_version: String by project
val jackson_version: String by project

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson_version")
}