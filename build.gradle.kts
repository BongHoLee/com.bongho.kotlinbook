
/* buildscript block에 대한 설명

      나머지 스크립트를 빌드하는 과정에서 필요한 외부 라이브러리를 classpath에 추가하는 기능을 담당합니다.
      subprojects 내에서 플러그인 적용(apply plugin)이 가능한 이유 또한 buildscript를 통해 라이브러리를 classpath에 추가시켰기 때문입니다.

     소스코드를 빌드하고 실행하는데 필요한 "글로벌 레벨의 dependencies & repositories" 설정
     다시말해 나머지 부분들에서 사용 가능한 플러그인, 태스크 등에 대해 결정

     외부의 플러그인 등을 사용할 때 종속 설정

     나머지 스크립트에 대한 이해를 위해 필요함

     build.gradle 자체에 대한 설정 파일이라고 보면 된다.

*/
buildscript{
    val springBootVersion =  "2.1.7.RELEASE"
    val kotlinVersion = "1.4.10"

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
    plugin("io.spring.dependency-management")   // 스프링 부트 의존성 관리를 위한 플러그인
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