package com.compose.umlcreater.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import com.compose.umlcreater.UmlApplier
import com.compose.umlcreater.node.PackageNode

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