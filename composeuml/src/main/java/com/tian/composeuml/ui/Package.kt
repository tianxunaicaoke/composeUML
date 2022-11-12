package com.tian.composeuml.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import com.tian.composeuml.UmlApplier
import com.tian.composeuml.node.PackageNode

@Composable
fun Package(name: String, content: @Composable () -> Unit) {
    ComposeNode<PackageNode, UmlApplier>(
        factory = { PackageNode(name) },
        update = {
            set(name) {
                this.name = it
            }
        },
        content = content
    )
}