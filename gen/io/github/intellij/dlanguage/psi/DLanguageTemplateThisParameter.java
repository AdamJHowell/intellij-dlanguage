package io.github.intellij.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;


public interface DLanguageTemplateThisParameter extends PsiElement {
    @Nullable
    PsiElement getKW_THIS();

    @Nullable
    DLanguageTemplateTypeParameter getTemplateTypeParameter();
}
