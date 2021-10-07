@file:Suppress("unused")

package com.nisecoder.intellij.plugins.nuxtjs.cna

import com.fasterxml.jackson.annotation.JsonValue


data class Answers(
    val name: String,
    val language: ProgrammingLanguage = ProgrammingLanguage.JavaScript,
    val pm: PackageManager = PackageManager.Yarn,
    val ui: UIFramework = UIFramework.None,
    val features: Set<NuxtModule> = emptySet(),
    val linter: Set<Linter> = emptySet(),
    val test: TestingFramework = TestingFramework.None,
    val mode: RenderingMode = RenderingMode.Universal,
    val target: DeploymentTarget = DeploymentTarget.Server,
    val devTools: Set<DevelopmentTool> = emptySet(),
    val ci: ContinuousIntegration = ContinuousIntegration.None,
    val gitUsername: String? = null,
    val vcs: VersionControlSystem = VersionControlSystem.Git,
)

enum class ProgrammingLanguage(@get:JsonValue val value: String) {
    JavaScript("js"),
    TypeScript("ts"),
}

enum class PackageManager(@get:JsonValue val value: String) {
    Yarn("yarn"),
    Npm("npm"),
}

enum class UIFramework(@get:JsonValue val value: String) {
    None("none"),
    AntDesignVue("ant-design-vue"),
    BalmUI("balm-ui"),
    BootstrapVue("bootstrap"),
    Buefy("buefy"),
    ChakraUI("chakra-ui"),
    Element("element-ui"),
    Framevuerk("framevuerk"),
    Oruga("oruga"),
    Tachyons("tachyons"),
    TailwindCSS("tailwind"),
    WindiCSS("windicss"),
    Vant("vant"),
    ViewUI("view-ui"),
    VuetifyJs("vuetify"),
}

enum class NuxtModule(@get:JsonValue val value: String) {
    Axios("axios"),
    PWA("pwa"),
    Content("content"),
}

enum class Linter(@get:JsonValue val value: String) {
    ESLint("eslint"),
    Prettier("prettier"),
    LintStagedFiles("lintStaged"),
    StyleLint("stylelint"),
    Commitlint("commitlint"),
}

enum class TestingFramework(@get:JsonValue val value: String) {
    None("none"),
    Jest("jest"),
    AVA("ava"),
    WebdriverIO("webdriverio"),
    Nightwatch("nightwatch"),
}

enum class RenderingMode(@get:JsonValue val value: String) {
    Universal("universal"),
    SinglePageApp("spa"),
}

enum class DeploymentTarget(@get:JsonValue val value: String) {
    Server("server"),
    Static("static"),
}

enum class DevelopmentTool(@get:JsonValue val value: String) {
    JSConfig("jsconfig"),
    SemanticPullRequests("semantic-pull-requests"),
    Dependabot("dependabot"),
}

enum class ContinuousIntegration(@get:JsonValue val value: String) {
    None("none"),
    GithubActions("github-actions"),
    TravisCI("travis-ci"),
    CircleCI("circleci"),
}


enum class VersionControlSystem(@get:JsonValue val value: String) {
    Git("git"),
    None("none"),
}
