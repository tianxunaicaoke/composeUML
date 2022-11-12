package com.tian.composeuml.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import com.tian.composeuml.UmlApplier
import com.tian.composeuml.node.FieldNode
import com.tian.composeuml.node.Qualifier

@Composable
fun Field(
    name: String,
    type: String,
    qualifier: Qualifier
) {
    ComposeNode<FieldNode, UmlApplier>(
        factory = { FieldNode(name, type, qualifier) },
        update = {
            set(name) {
                this.name = it
            }
            set(type) {
                this.type = it
            }
            set(qualifier) {
                this.qualifier = it
            }
        }
    )
}