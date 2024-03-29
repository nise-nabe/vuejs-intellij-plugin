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
        kotlin("jvm") version "1.6.21"
        id("org.jetbrains.intellij") version "1.13.1"
        id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.7"
    }
}
