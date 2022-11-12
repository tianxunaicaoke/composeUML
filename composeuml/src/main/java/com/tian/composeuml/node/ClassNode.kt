package com.compose.umlcreater.node

class ClassNode(
    var name: String
) : ClassDiagramUmlNode() {
    override fun convertToUMLText(): String {
        return children.joinToString(separator = "\n", "class $name {", postfix = "}") {
            it.convertToUMLText()
        }
    }
}