import com.nisecoder.gradle.plugin.idea.ext.packagePrefix
import com.nisecoder.gradle.plugin.idea.ext.settings

plugins {
    kotlin("jvm")
    id("org.jetbrains.intellij")
    id("org.jetbrains.gradle.plugin.idea-ext")
    id("com.nisecoder.idea-ext-ext")
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
            packagePrefix["src/main/kotlin"]
        }
    }
}
// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2021.2.2")
    type.set("IU")
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
