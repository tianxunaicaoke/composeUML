package com.compose.umlcreater.node

class FieldNode(
    private val name: String,
    private val qualifier: Qualifier
) : ClassDiagramUmlNode() {
    override fun convertToUMLText(): String {
        return qualifier.toString() + name
    }
}