package com.compose.umlcreater.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import com.compose.umlcreater.UmlApplier
import com.compose.umlcreater.node.ClassNode

@Composable
fun Class(
    name: String,
    content: @Composable () -> Unit
) {
    ComposeNode<ClassNode, UmlApplier>(
        factory = { ClassNode(name) },
        update = {
            set(name) {
                this.name = it
            }
        },
        content = content
    )
}