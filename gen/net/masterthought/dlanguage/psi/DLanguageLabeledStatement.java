// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import net.masterthought.dlanguage.psi.interfaces.DNamedElement;
import net.masterthought.dlanguage.psi.interfaces.containers.StatementContainer;
import com.intellij.psi.StubBasedPsiElement;
import net.masterthought.dlanguage.stubs.DLanguageLabeledStatementStub;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public interface DLanguageLabeledStatement extends DNamedElement, StatementContainer, StubBasedPsiElement<DLanguageLabeledStatementStub> {

  @NotNull
  DLanguageIdentifier getIdentifier();

  @Nullable
  DLanguageStatement getStatement();

  @NotNull
  PsiElement getOpColon();

  @NotNull
  String getName();

  String getFullName();

  @Nullable
  PsiElement getNameIdentifier();

  @NotNull
  PsiReference getReference();

  @NotNull
  PsiElement setName(String newName);

  @NotNull
  ItemPresentation getPresentation();

  //WARNING: processDeclarations(...) is skipped
  //matching processDeclarations(DLanguageLabeledStatement, ...)
  //methods are not found in DPsiImplUtil

}
