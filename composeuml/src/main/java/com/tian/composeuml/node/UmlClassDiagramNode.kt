package com.tian.composeuml.node

import android.util.Log
import com.tian.composeuml.uml.ClassFileGenerator

class UmlClassDiagramNode(
    private val classFileGenerator: ClassFileGenerator
) : ClassDiagramUmlNode() {

    fun render(): String {
        return classFileGenerator.generate(this)
    }

    override fun layout(): String {
        val umlString =
            children.joinToString(
                separator = "\n",
                prefix = "@startUml\n",
                postfix = "@endUml\n"
            ) {
                it.layout()
            }
        Log.e("David", umlString)
        return umlString
    }
}