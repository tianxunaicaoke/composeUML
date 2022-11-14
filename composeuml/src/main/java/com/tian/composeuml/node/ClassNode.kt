package com.tian.composeuml.node

class ClassNode(
    var name: String
) : ClassDiagramUmlNode() {
    override fun layout(): String {
        return children.joinToString(separator = "\n", "class $name { \n", postfix = "\n }") {
            it.layout()
        }
    }
}