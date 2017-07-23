package net.masterthought.dlanguage.processors

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.ResolveState
import net.masterthought.dlanguage.psi.DPsiUtil.getNumParameters
import net.masterthought.dlanguage.utils.FunctionCallExpression
import net.masterthought.dlanguage.utils.FunctionDeclaration

/**
 * Created by francis on 7/22/2017.
 */
class DFunctionProcessor(val e: PsiNamedElement, val functionCallExpression: FunctionCallExpression) : DResolveProcessor<FunctionCallExpression, FunctionDeclaration> {
    override fun matches(call: FunctionCallExpression, decl: FunctionDeclaration): Boolean {
        //todo change this to check that the call name is the same
        if (e.name == decl.name) {
            val range = getNumParameters(decl.parameters!!)
            val size = call.arguments!!.argumentList!!.assignExpressions.size
            if (range.matches(size)) {
                return true
            }
        }
        return false
    }

    override fun execute(element: PsiElement, state: ResolveState): Boolean {
        if (element is FunctionDeclaration) {
            if (matches(functionCallExpression, element)) {
                result.add(element)
            }
        }
        return true
    }

    override val result: MutableSet<FunctionDeclaration> = mutableSetOf()

}

