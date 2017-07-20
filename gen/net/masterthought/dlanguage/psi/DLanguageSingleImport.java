package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import net.masterthought.dlanguage.psi.interfaces.DNamedElement;
import net.masterthought.dlanguage.stubs.DLanguageSingleImportStub;
import org.jetbrains.annotations.Nullable;


public interface DLanguageSingleImport extends PsiElement, DNamedElement, StubBasedPsiElement<DLanguageSingleImportStub> {
    @Nullable
    DLanguageIdentifier getIdentifier();

    @Nullable
    PsiElement getOP_EQ();

    @Nullable
    DLanguageIdentifierChain getIdentifierChain();
}
