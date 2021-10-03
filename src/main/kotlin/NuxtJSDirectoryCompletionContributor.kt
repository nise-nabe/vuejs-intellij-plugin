package com.nisecoder.intellij.plugins.nuxtjs

import com.intellij.ide.actions.CreateDirectoryCompletionContributor
import com.intellij.psi.PsiDirectory
import org.jetbrains.jps.model.java.JavaSourceRootType

class NuxtJSDirectoryCompletionContributor: CreateDirectoryCompletionContributor {
    override fun getDescription(): String {
        return "Nuxtjs Directory"
    }

    override fun getVariants(directory: PsiDirectory): MutableCollection<CreateDirectoryCompletionContributor.Variant> {
        val result = mutableListOf<CreateDirectoryCompletionContributor.Variant>()
        result.add(CreateDirectoryCompletionContributor.Variant("layouts", JavaSourceRootType.SOURCE))
        return result;
    }
}
