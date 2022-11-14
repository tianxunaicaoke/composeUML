package com.tian.composeuml.node

class FieldNode(
    var name: String,
    var type: String,
    var qualifier: Qualifier
) : ClassDiagramUmlNode() {
    override fun layout(): String {
        return "${qualifier.toName()} $type $name"
    }
}