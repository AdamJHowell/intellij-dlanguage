package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;


public interface DLanguageAtAttribute extends PsiElement {
    @Nullable
    PsiElement getOP_AT();

    @Nullable
    PsiElement getOP_PAR_LEFT();

    @Nullable
    PsiElement getOP_PAR_RIGHT();

    @Nullable
    DLanguageIdentifier getIdentifier();

    @Nullable
    DLanguageArgumentList getArgumentList();

    @Nullable
    DLanguageFunctionCallExpression getFunctionCallExpression();
}
