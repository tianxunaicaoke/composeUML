package com.tian.composeuml.node

class MethodNode(
    var name: String,
    var qualifier: Qualifier
) : ClassDiagramUmlNode() {
    override fun layout(): String {
        return "${qualifier.toName()} $name()"
    }
}

fun Qualifier.toName() = when (this) {
    is Qualifier.Private -> "-"
    is Qualifier.Protect -> "#"
    is Qualifier.Public -> "+"
}

sealed class Qualifier {
    object Private : Qualifier()
    object Public : Qualifier()
    object Protect : Qualifier()
}