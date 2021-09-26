rootProject.name = "nuxtjs-intellij-plugin"

pluginManagement {
    repositories {
        gradlePluginPortal()
        exclusiveContent {
            forRepository {
                maven {
                    name = "gitHubPackages"
                    url = uri("https://maven.pkg.github.com/nise-nabe/gradle-plugins")
                    credentials(PasswordCredentials::class)
                }
            }
            filter {
                includeGroup("com.nisecoder.gradle.plugin")
            }
        }
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.nisecoder.idea-ext-ext")) {
                useModule("com.nisecoder.gradle.plugin:idea-ext-ext:0.0.1")
            }
        }
    }

    plugins {
        kotlin("jvm") version "1.5.31"
        id("org.jetbrains.intellij") version "1.1.6"
        id("org.jetbrains.gradle.plugin.idea-ext") version "1.0.1"
    }
}
