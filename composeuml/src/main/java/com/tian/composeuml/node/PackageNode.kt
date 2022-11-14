package com.tian.composeuml.node

class PackageNode(
    var name: String
) : ClassDiagramUmlNode() {

    override fun layout(): String {
        return children.joinToString(
            separator = "\n",
            prefix = "package \"${name}\" {\n",
            postfix = "\n}"
        ) {
            it.layout()
        }
    }
}