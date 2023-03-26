

dependencies {
    implementation("com.auth0:java-jwt:4.3.0")
    implementation("at.favre.lib:bcrypt:0.9.0")


    implementation("org.mariadb:r2dbc-mariadb:1.1.3")

//    implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
//    runtimeOnly("mysql:mysql-connector-java")
//    runtimeOnly("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
}
