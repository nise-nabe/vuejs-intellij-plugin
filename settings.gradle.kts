rootProject.name = "nuxtjs-intellij-plugin"

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
        kotlin("jvm") version "1.5.31"
        id("org.jetbrains.intellij") version "1.3.0"
        id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.1"
        id("com.nisecoder.idea-ext-ext") version "0.0.8"
    }
}
