package com.tian.composeuml.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import com.tian.composeuml.UmlApplier
import com.tian.composeuml.node.ClassNode

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