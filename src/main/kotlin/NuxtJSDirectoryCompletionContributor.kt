package com.nisecoder.intellij.vuejs

import com.intellij.ide.actions.CreateDirectoryCompletionContributor
import com.intellij.ide.actions.CreateDirectoryCompletionContributor.Variant
import com.intellij.psi.PsiDirectory
import com.nisecoder.intellij.vuejs.jps.NuxtJSRootType

class NuxtJSDirectoryCompletionContributor: CreateDirectoryCompletionContributor {
    override fun getDescription(): String {
        return "Nuxtjs Directory"
    }

    /**
     * https://nuxtjs.org/docs/directory-structure
     */
    override fun getVariants(directory: PsiDirectory): MutableCollection<Variant> {
        // nuxt.config で srcDir  が設定されているとディレクトリベースも変える必要がある
        // TODO: nuxt.config をパースする方法 or nuxt がパースした結果を取得する方法
        val result = mutableListOf<Variant>()
        result.add(Variant("assets", NuxtJSRootType.INSTANCE))
        result.add(Variant("components", NuxtJSRootType.INSTANCE))
        result.add(Variant("content", NuxtJSRootType.INSTANCE))
        result.add(Variant("layouts", NuxtJSRootType.INSTANCE))
        result.add(Variant("middleware", NuxtJSRootType.INSTANCE))
        result.add(Variant("modules", NuxtJSRootType.INSTANCE))
        result.add(Variant("pages", NuxtJSRootType.INSTANCE))
        result.add(Variant("plugins", NuxtJSRootType.INSTANCE))
        result.add(Variant("store", NuxtJSRootType.INSTANCE))
        return result;
    }
}
