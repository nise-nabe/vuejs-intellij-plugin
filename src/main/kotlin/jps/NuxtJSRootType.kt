package com.nisecoder.intellij.vuejs.jps

import org.jetbrains.jps.model.JpsDummyElement
import org.jetbrains.jps.model.ex.JpsElementTypeWithDummyProperties
import org.jetbrains.jps.model.module.JpsModuleSourceRootType

class NuxtJSRootType: JpsElementTypeWithDummyProperties(), JpsModuleSourceRootType<JpsDummyElement> {
    companion object {
        val INSTANCE = NuxtJSRootType()
    }
}
