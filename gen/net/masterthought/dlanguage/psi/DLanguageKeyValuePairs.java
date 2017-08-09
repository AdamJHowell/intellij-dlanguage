package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public interface DLanguageKeyValuePairs extends PsiElement {
    @NotNull
    List<PsiElement> getOP_COMMAs();

    @NotNull
    List<DLanguageKeyValuePair> getKeyValuePairs();
}
