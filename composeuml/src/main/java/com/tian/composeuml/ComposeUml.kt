package com.tian.composeuml

import androidx.compose.runtime.BroadcastFrameClock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import com.tian.composeuml.node.UmlClassDiagramNode
import com.tian.composeuml.node.setContent
import com.tian.composeuml.uml.ClassFileGenerator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun runComposeUml(
    scope: CoroutineScope,
    printLayout: (String) -> Unit,
    content: @Composable () -> Unit
) = scope.launch {
    val frameClock = BroadcastFrameClock()
    val effectCoroutineContext = Job(coroutineContext[Job]) + frameClock
    val root = UmlClassDiagramNode(ClassFileGenerator())
    launch {
        SnapshotManager.ensureStarted()
    }

    val reComposer = Recomposer(effectCoroutineContext)
    val composition = root.setContent(reComposer, content)

    launch(context = frameClock, start = CoroutineStart.UNDISPATCHED) {
        reComposer.runRecomposeAndApplyChanges()
    }

    launch {
        frameClock.dispatchFrame(
            refreshRate = 1000L,
            timeNanos = { System.nanoTime() },
            frameCallBack = {
                printLayout(root.render())
            }
        )
    }
}

internal suspend fun BroadcastFrameClock.dispatchFrame(
    refreshRate: Long,
    timeNanos: () -> Long,
    frameCallBack: suspend () -> Unit
) {
    while (true) {
        sendFrame(timeNanos())
        frameCallBack()

        delay(refreshRate)
    }
}