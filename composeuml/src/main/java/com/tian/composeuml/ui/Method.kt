package com.compose.umlcreater.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import com.compose.umlcreater.UmlApplier
import com.compose.umlcreater.node.MethodNode
import com.compose.umlcreater.node.Qualifier

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