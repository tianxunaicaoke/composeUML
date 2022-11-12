package com.tian.composeuml.node

import android.util.Log

class UmlClassDiagramNode : ClassDiagramUmlNode() {
    override fun convertToUMLText(): String {
        val umlString = children.joinToString {
            it.convertToUMLText()
        }
        Log.e("David", umlString)
        return umlString
    }
}