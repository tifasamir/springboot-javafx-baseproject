import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("java")
	id("org.openjfx.javafxplugin") version "0.0.13"
	id("org.javamodularity.moduleplugin") version "1.8.12"
	id("application")
	id("org.beryx.jlink") version "2.25.0"
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"

}

group = "com.tifalab"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}
javafx {
	version = "17.0.6"
	modules = arrayOf("javafx.controls", "javafx.fxml"
//		, "javafx.web"
//		,
//		"javafx.media"
		,"javafx.base"
//		,"javafx.graphics"
//		,"javafx.media",
//		"javafx.web"
	).toMutableList()
//	modules =  mutableListOf<String>(
//		 "javafx.controls",
//		"javafx.fxml",
//		"javafx.web",
//		"javafx.media",
//		"javafx.graphics",
//		"javafx.media",
//		"javafx.web"
//	)
}
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.controlsfx:controlsfx:11.1.2")
	implementation("com.dlsc.formsfx:formsfx-core:11.6.0"){
//    exclude(group: "org.openjfx")
	}
	implementation("net.synedra:validatorfx:0.4.0"){
//    exclude(group: "org.openjfx")
	}
	implementation("org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0")



}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

application {
	mainModule = "com.example.fx_tstq"
	mainClass = "com.example.fx_tstq.HelloApplication"
}