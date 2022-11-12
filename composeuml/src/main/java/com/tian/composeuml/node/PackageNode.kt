package com.tian.composeuml.node

class PackageNode(
    var name: String
) : ClassDiagramUmlNode() {

    override fun convertToUMLText(): String {
        return children.joinToString(
            separator = "\n",
            prefix = "package \"${name}\" {\n",
            postfix = "\n}"
        ) {
            it.convertToUMLText()
        }
    }
}