plugins {
    kotlin("jvm") version "1.9.22"
    application
}

group = "com.spaceagency"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
}

application {
    mainClass.set("MainKt")
}
