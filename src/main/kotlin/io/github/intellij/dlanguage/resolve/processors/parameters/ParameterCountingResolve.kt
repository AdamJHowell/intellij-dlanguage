package io.github.intellij.dlanguage.resolve.processors.parameters

import com.google.common.collect.Sets
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.ResolveState
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.util.PsiTreeUtil
import io.github.intellij.dlanguage.index.DModuleIndex
import io.github.intellij.dlanguage.processors.DImportScopeProcessor
import io.github.intellij.dlanguage.psi.DlangTypes
import io.github.intellij.dlanguage.psi.interfaces.DNamedElement
import io.github.intellij.dlanguage.resolve.DResolveUtil
import io.github.intellij.dlanguage.resolve.processors.DNameScopeProcessor
import io.github.intellij.dlanguage.resolve.processors.DResolveProcessor
import io.github.intellij.dlanguage.stubs.index.DTopLevelDeclarationIndex
import io.github.intellij.dlanguage.utils.*

/**
 * Created by francis on 7/24/2017.
 */

//this isn't actually deprecated, just too difficult  to do without a functioning type deduction system.
@Deprecated("") object ParameterCountingResolve {
    enum class ResolveType {
        FUNCTION, CONSTRUCTOR, ALL
    }


    fun inSingleImport(identifier: Identifier): SingleImport? {
        return PsiTreeUtil.getTopmostParentOfType(identifier, SingleImport::class.java)
    }

    fun inFunctionUsage(identifier: Identifier): FunctionCallExpression? {
        return DPsiUtil.getParent(identifier, setOf(io.github.intellij.dlanguage.psi.DlangTypes.FUNCTION_CALL_EXPRESSION), setOf(io.github.intellij.dlanguage.psi.DlangTypes.EXPRESSION, io.github.intellij.dlanguage.psi.DlangTypes.ARGUMENTS)) as FunctionCallExpression?
    }


    fun findDefinitionNode(project: Project, e: PsiNamedElement): Set<PsiNamedElement> {
        //todo fix templated functions return type bug

        //this is here to get the kotlin smart casts
        if (e !is Identifier) {
            return emptySet()
        }

        if (inSingleImport(e) != null) {
            return Sets.newHashSet(io.github.intellij.dlanguage.index.DModuleIndex.getFilesByModuleName(project, inSingleImport(e)!!.name, GlobalSearchScope.allScope(project)))
        }

        val resolveType: ResolveType
        val processor: DResolveProcessor<PsiElement, io.github.intellij.dlanguage.psi.interfaces.DNamedElement>
        if (inFunctionUsage(e) != null) {
            processor = DFunctionProcessor(e, inFunctionUsage(e)!!) as DResolveProcessor<PsiElement, io.github.intellij.dlanguage.psi.interfaces.DNamedElement>
            PsiTreeUtil.treeWalkUp(processor, e, e.containingFile, ResolveState.initial())
            resolveType = ResolveType.FUNCTION
        } else if (DResolveUtil.getInstance(project).resolvingConstructor(e) != null) {
            processor = DConstructorProcessor(e, DResolveUtil.getInstance(project).resolvingConstructor(e)!!) as DResolveProcessor<PsiElement, io.github.intellij.dlanguage.psi.interfaces.DNamedElement>
            PsiTreeUtil.treeWalkUp(processor, e, e.containingFile, ResolveState.initial())
            resolveType = ResolveType.CONSTRUCTOR
        } else {
            processor = DNameScopeProcessor(e) as DResolveProcessor<PsiElement, io.github.intellij.dlanguage.psi.interfaces.DNamedElement>
            PsiTreeUtil.treeWalkUp(processor, e, e.containingFile, ResolveState.initial())
            resolveType = ResolveType.ALL
        }
        if (processor.result.isNotEmpty()) {
            return processor.result
        }

        return findDefinitionNodeFromImports(e, project, resolveType)
    }

    private fun findDefinitionNodeFromImports(e: Identifier, project: Project, resolveType: ResolveType): Set<PsiNamedElement> {
        val importProcessor = DImportScopeProcessor()
        PsiTreeUtil.treeWalkUp(importProcessor, e, e.containingFile, ResolveState.initial())
        val modules: MutableList<String> = mutableListOf()

        (importProcessor.imports).mapTo(modules) { it.name }
        val result = mutableSetOf<PsiNamedElement>()
        // find definition in imported files
        for (module in modules) {
            //todo use only stub tree to improve performance here and maybe not make every identifier a stub
            val files = io.github.intellij.dlanguage.index.DModuleIndex.getFilesByModuleName(project, module, GlobalSearchScope.allScope(project))
            for (f in files) {
                for (element in StubIndex.getElements(DTopLevelDeclarationIndex.KEY, e.name, e.project, GlobalSearchScope.fileScope(f), io.github.intellij.dlanguage.psi.interfaces.DNamedElement::class.java)) {
                    when (resolveType) {
                        ResolveType.FUNCTION -> {
                            if (element is FunctionDeclaration) {
                                if (DFunctionProcessor(e, inFunctionUsage(e)!!).matches(inFunctionUsage(e)!!, element)) {
                                    result.add(element)
                                }
                            }
                        }
                        ResolveType.CONSTRUCTOR -> {
                            if (element is Constructor) {
                                if (DConstructorProcessor(e, DResolveUtil.getInstance(project).resolvingConstructor(e)!!).matches(DResolveUtil.getInstance(project).resolvingConstructor(e)!!, element)) {
                                    result.add(element)
                                }
                            }
                        }
                        ResolveType.ALL -> {
                            if (element !is Constructor) {
                                result.add(element)
                            }
                        }
                    }
                }
            }
        }
        return result
    }

}
