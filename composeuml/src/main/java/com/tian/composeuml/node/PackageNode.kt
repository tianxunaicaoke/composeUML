package com.compose.umlcreater.node

class PackageNode(
    var name: String
) : ClassDiagramUmlNode() {

    override fun convertToUMLText(): String {
        return children.joinToString(
            separator = "\n",
            prefix = "package \"${name}\" {",
            postfix = "}"
        ) {
            it.convertToUMLText()
        }
    }
}