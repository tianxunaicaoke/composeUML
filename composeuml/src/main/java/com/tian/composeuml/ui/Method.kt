package com.tian.composeuml.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import com.tian.composeuml.UmlApplier
import com.tian.composeuml.node.MethodNode
import com.tian.composeuml.node.Qualifier

@Composable
fun Method(
    name: String,
    qualifier: Qualifier
) {
    ComposeNode<MethodNode, UmlApplier>(
        factory = { MethodNode(name, qualifier) },
        update = {
            set(name) {
                this.name = it
            }
            set(qualifier) {
                this.qualifier = it
            }
        }
    )
}