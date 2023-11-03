import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("application")
//    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("org.javamodularity.moduleplugin") version "1.8.12"
    id("org.openjfx.javafxplugin") version "0.0.13"
    id("org.beryx.jlink") version "2.25.0"
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
    id("org.jetbrains.kotlin.plugin.spring") version "1.8.22"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.8.22"
}

group="com.example"
version="1.0-SNAPSHOT"

repositories {
    mavenCentral()
}



application {
        mainModule.set("com.tifalab.engine")
        mainModule.set("com.tifalab.engine.EngineApplication")
}

project.tasks.withType(KotlinCompile::class.java).configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }

}
javafx {
    version = "17.0.6"
    modules = mutableListOf<String>(
        "javafx.controls",
        "javafx.graphics",
        "javafx.fxml" ,
        "javafx.web",
    )
}

dependencies {
    implementation("org.controlsfx:controlsfx:11.1.2")
    implementation("com.dlsc.formsfx:formsfx-core:11.6.0") {
        exclude(group = "org.openjfx")
    }
    implementation("net.synedra:validatorfx:0.4.0") {
        exclude(group = "org.openjfx")
    }
    implementation("org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0")

    implementation("org.springframework.boot:spring-boot-starter")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.test {
    useJUnitPlatform()
}

jlink {
    imageZip.set(project.file("${buildDir}/distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    launcher {
        name = "app"
    }
}


//jlinkZip{
//    group ="distribution"
////    group.set("distribution")
//}