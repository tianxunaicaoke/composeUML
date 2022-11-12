package com.compose.umlcreater.node

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.CompositionContext
import com.compose.umlcreater.UmlApplier

abstract class ClassDiagramUmlNode : UmlNode {
    val children = mutableListOf<ClassDiagramUmlNode>()
}

fun ClassDiagramUmlNode.setContent(
    parent: CompositionContext,
    content: @Composable () -> Unit
): Composition{
   return Composition(UmlApplier(this), parent).apply {
       setContent(content)
   }
}
