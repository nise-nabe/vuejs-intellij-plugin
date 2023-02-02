rootProject.name = "vuejs-intellij-plugin"

pluginManagement {
    repositories {
        gradlePluginPortal()
        exclusiveContent {
            forRepository {
                maven {
                    name = "gitHub"
                    url = uri("https://maven.pkg.github.com/nise-nabe/gradle-plugins")
                    credentials(PasswordCredentials::class)
                }
            }
            filter {
                includeGroupByRegex("com.nisecoder.*")
            }
        }
    }

    plugins {
        kotlin("jvm") version "1.8.10"
        id("org.jetbrains.intellij") version "1.12.0"
        id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.7"
    }
}
