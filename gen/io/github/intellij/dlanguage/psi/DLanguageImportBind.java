package io.github.intellij.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;


public interface DLanguageImportBind extends PsiElement {
    @Nullable
    DlangIdentifier getIdentifier();

    @Nullable
    DLanguageNamedImportBind getNamedImportBind();
}
