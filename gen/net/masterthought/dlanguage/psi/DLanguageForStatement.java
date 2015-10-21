// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageForStatement extends PsiElement {

  @Nullable
  DLanguageDeclaration getDeclaration();

  @NotNull
  DLanguageDeclarationOrStatement getDeclarationOrStatement();

  @NotNull
  List<DLanguageExpression> getExpressionList();

  @Nullable
  DLanguageStatementNoCaseNoDefault getStatementNoCaseNoDefault();

  @NotNull
  PsiElement getKwFor();

  @NotNull
  PsiElement getOpParLeft();

  @NotNull
  PsiElement getOpParRight();

  @NotNull
  PsiElement getOpScolon();

}
