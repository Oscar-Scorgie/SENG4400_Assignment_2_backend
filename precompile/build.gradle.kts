
plugins {
    id("java")
    application
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(platform("software.amazon.awssdk:bom:2.42.36"))
    implementation("software.amazon.awssdk:dynamodb")
    implementation("software.amazon.awssdk:lambda")
    implementation("software.amazon.awssdk:apigateway")
}

application {
    mainClass.set("org.example.LocalStackCompile")
}

tasks.named<JavaExec>("run") {
    workingDir = rootProject.projectDir
}

tasks.test {
    useJUnitPlatform()
}