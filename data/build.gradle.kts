val exposed_version: String by project
val mariadb_version: String by project

dependencies {
    api(project(":usecase"))
    api(project(":entity"))

    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("com.zaxxer:HikariCP:5.0.0")
    implementation("org.mariadb.jdbc:mariadb-java-client:$mariadb_version")

}