import org.jetbrains.gradle.ext.packagePrefix
import org.jetbrains.gradle.ext.settings

plugins {
    kotlin("jvm")
    id("org.jetbrains.intellij")
    id("org.jetbrains.gradle.plugin.idea-ext")
}

group = "com.nisecoder.intellij"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

idea {
    module {
        settings {
            packagePrefix["src/main/kotlin"] = "com.nisecoder.intellij.vuejs"
            packagePrefix["src/test/kotlin"] = "com.nisecoder.intellij.vuejs"
        }
    }
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2022.1")
    type.set("IU")
    downloadSources.set(true)
    plugins.set(listOf(
        "JavaScriptLanguage",
        "JavaScriptDebugger",
    ))
}

tasks {
    runIde {
        autoReloadPlugins.set(true)
    }
    patchPluginXml {
        changeNotes.set("""
            Add change notes here.<br>
            <em>most HTML tags may be used</em>        """.trimIndent())
    }
}
