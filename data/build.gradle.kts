val exposed_version: String by project
val mariadb_version: String by project
val retrofit_version: String by project

fun exposed(module: String) = "org.jetbrains.exposed:exposed-$module:$exposed_version"

dependencies {
    api(project(":usecase"))
    api(project(":entity"))

    implementation(exposed("core"))
    implementation(exposed("jdbc"))
    implementation(exposed("dao"))
    implementation(exposed("java-time"))
    implementation("com.zaxxer:HikariCP:5.0.0")
    implementation("org.mariadb.jdbc:mariadb-java-client:$mariadb_version")
    api("com.squareup.retrofit2:retrofit:$retrofit_version")
    api("com.auth0:java-jwt:3.18.2")
}