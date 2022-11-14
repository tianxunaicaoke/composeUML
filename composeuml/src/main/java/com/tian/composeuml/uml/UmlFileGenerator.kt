package com.tian.composeuml.uml

import com.tian.composeuml.node.ClassDiagramUmlNode
import com.tian.composeuml.node.UmlNode

interface UmlFileGenerator<T : UmlNode> {
    fun generate(node: T): String
}

class ClassFileGenerator : UmlFileGenerator<ClassDiagramUmlNode> {
    override fun generate(node: ClassDiagramUmlNode): String {
        return node.layout()
    }
}