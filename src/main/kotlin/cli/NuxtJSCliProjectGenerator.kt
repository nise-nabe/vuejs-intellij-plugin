package com.nisecoder.intellij.vuejs.cli

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.intellij.execution.filters.Filter
import com.intellij.ide.util.projectWizard.SettingsStep
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.ProjectGeneratorPeer
import com.intellij.ui.IconManager
import com.intellij.ui.components.JBTextField
import com.nisecoder.intellij.vuejs.NuxtJSBundle
import com.nisecoder.intellij.vuejs.cna.Answers
import com.nisecoder.intellij.vuejs.ui.getIcon
import javax.swing.Icon
import javax.swing.JPanel

class NuxtJSCliProjectGenerator: NpmPackageProjectGenerator() {
    companion object {
        const val PACKAGE_NAME = "create-nuxt-app"
        const val NUXT_EXECUTABLE = "create-nuxt-app"
        private val objectMapper = jacksonObjectMapper()
    }

    override fun getLogo(): Icon {
        return IconManager.getInstance().getIcon<NuxtJSCliProjectGenerator>("Nuxt_logo.svg")
    }

    override fun getName(): String = NuxtJSBundle.message("nuxtjs.project.generator.name")

    override fun getDescription(): String = NuxtJSBundle.message("nuxtjs.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile): Array<Filter> = emptyArray()

    override fun customizeModule(baseDir: VirtualFile, entry: ContentEntry) { }

    override fun packageName(): String = PACKAGE_NAME

    override fun presentablePackageName(): String
            = NuxtJSBundle.message("nuxtjs.project.generator.presentable.package.name")

    override fun getNpxCommands(): MutableList<NpxPackageDescriptor.NpxCommand>
            = mutableListOf(NpxPackageDescriptor.NpxCommand(PACKAGE_NAME, NUXT_EXECUTABLE))


    override fun generatorArgs(project: Project, dir: VirtualFile, settings: Settings): Array<String> {
        val answer = Answers(
            name = project.name,
        )
        return arrayOf("--overwrite-dir", "--answers",  objectMapper.writeValueAsString(answer))
    }


    val packageManagerKey = Key.create<String>("nuxtjs.project.generator.package.manager")

    override fun createPeer(): ProjectGeneratorPeer<Settings> {
        val packageManager = JBTextField("package manager")

        return object : NpmPackageGeneratorPeer() {
            override fun createPanel(): JPanel {
                val panel = super.createPanel()

                panel.add(packageManager)

                return panel
            }

            override fun buildUI(settingsStep: SettingsStep) {
                super.buildUI(settingsStep)
                settingsStep.addSettingsComponent(packageManager)
            }

            override fun getSettings(): Settings {
                val settings = super.getSettings()
                settings.putUserData(packageManagerKey, packageManager.text)
                return settings
            }
        }
    }
}
