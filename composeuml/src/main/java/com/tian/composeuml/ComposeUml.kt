package com.compose.umlcreater

import androidx.compose.runtime.BroadcastFrameClock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import com.compose.umlcreater.node.UmlClassDiagramNode
import com.compose.umlcreater.node.setContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun runComposeUml(
    scope: CoroutineScope,
    content: @Composable () -> Unit
) = scope.launch {
    val frameClock = BroadcastFrameClock()
    val effectCoroutineContext = Job(coroutineContext[Job]) + frameClock
    val root = UmlClassDiagramNode()
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
                root.convertToUMLText()
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