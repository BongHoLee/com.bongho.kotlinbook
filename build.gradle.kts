import org.gradle.kotlin.dsl.ext

buildscript{
    val springBootVersion =  "2.1.1.RELEASE"
    var kotlinVersion = "1.4.10"

    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")

    }
}

plugins {
    java
    kotlin("jvm") version "1.4.10"
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("eclipse")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {

    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit", "junit", "4.12")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-test")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}