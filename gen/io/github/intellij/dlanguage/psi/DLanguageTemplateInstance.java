package io.github.intellij.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;


public interface DLanguageTemplateInstance extends PsiElement {
    @Nullable
    DlangIdentifier getIdentifier();

    @Nullable
    DLanguageTemplateArguments getTemplateArguments();
}
