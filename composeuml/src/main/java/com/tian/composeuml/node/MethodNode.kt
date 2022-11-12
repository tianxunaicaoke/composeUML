package com.compose.umlcreater.node

class MethodNode(
    var name: String,
    var qualifier: Qualifier
): ClassDiagramUmlNode() {
    override fun convertToUMLText(): String {
        return qualifier.toString() + name
    }
}

sealed class Qualifier{
    object Private: Qualifier()
    object Public: Qualifier()
    object Protect: Qualifier()
}