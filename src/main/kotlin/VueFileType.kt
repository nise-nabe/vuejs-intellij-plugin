package com.nisecoder.intellij.vuejs

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.ui.IconManager
import com.nisecoder.intellij.vuejs.ui.getIcon
import javax.swing.Icon

class VueFileType: LanguageFileType(VueLanguage()) {
    companion object {
        @JvmStatic
        @Suppress("unused")
        val INSTANCE: VueFileType = VueFileType()
    }

    /** this should be same with plugin.xml fileType name*/
    override fun getName(): String = "Vue.js"
    override fun getDescription(): String  = "Description"
    override fun getDefaultExtension(): String = "vue"

    override fun getIcon(): Icon = IconManager.getInstance().getIcon<VueFileType>("vue_logo.svg")
}
