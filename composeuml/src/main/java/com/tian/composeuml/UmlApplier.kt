package com.compose.umlcreater

import androidx.compose.runtime.AbstractApplier
import com.compose.umlcreater.node.ClassDiagramUmlNode

class UmlApplier(root: ClassDiagramUmlNode) : AbstractApplier<ClassDiagramUmlNode>(root) {
    override fun onClear() {
        root.children.clear()
    }

    override fun insertBottomUp(index: Int, instance: ClassDiagramUmlNode) {
    }

    override fun insertTopDown(index: Int, instance: ClassDiagramUmlNode) {
        current.children.add(index, instance)
    }

    override fun move(from: Int, to: Int, count: Int) {
        current.children.move(from, to, count)
    }

    override fun remove(index: Int, count: Int) {
        current.children.remove(index, count)
    }
}