package com.nisecoder.intellij.plugins.nuxtjs.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nisecoder.intellij.plugins.nuxtjs.NuxtJSBundle

class NuxtJSCliProjectGenerator: NpmPackageProjectGenerator() {
    companion object {
        const val PACKAGE_NAME = "create-nuxt-app"
        const val NUXT_EXECUTABLE = "create-nuxt-app"
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

    override fun generatorArgs(project: Project, baseDir: VirtualFile): Array<String>
            = arrayOf("--overwrite-dir")
}
