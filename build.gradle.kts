import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.net.InetAddress

plugins {
    kotlin("jvm") version "1.9.21"
    id("com.github.johnrengelman.shadow") version "8.1.1" // Update to the latest Shadow plugin version
    application
}

group = "in.sud-dhi.webapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(platform("io.dropwizard:dropwizard-bom:4.0.4"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.dropwizard:dropwizard-core")

    //Auth
    implementation("io.dropwizard:dropwizard-auth")

    //UUID
    implementation("com.github.f4b6a3:ulid-creator:5.2.2")

    // Database
    implementation("io.dropwizard:dropwizard-jdbi3")
    implementation("org.xerial:sqlite-jdbc:3.34.0")



}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "21" // Use 1.8 instead of 21
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "21" // Use 1.8 instead of 21
    }

    named<JavaExec>("run") {
        args = listOf("server", "config.yml")
    }
}
tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("shadow")
        mergeServiceFiles()
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
        manifest {
            attributes(mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version,
                "Implementation-Vendor-Id" to project.group,
                "Built-By" to InetAddress.getLocalHost().hostName,
                "Created-By" to "Gradle " + gradle.gradleVersion,
                "Main-Class" to "in.sudhi.webapp.Applicationkt"))
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}

