// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageBlockStatement extends PsiElement {

  @Nullable
  DLanguageStatementList getStatementList();

  @NotNull
  PsiElement getOpBracesLeft();

  @NotNull
  PsiElement getOpBracesRight();

  //WARNING: processDeclarations(...) is skipped
  //matching processDeclarations(DLanguageBlockStatement, ...)
  //methods are not found in DPsiImplUtil

}
