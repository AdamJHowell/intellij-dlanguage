package net.masterthought.dlanguage.psi.interfaces;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface DDefinitionFunction extends DCompositeElement {

    @NotNull
    PsiElement getSymbol();

}

