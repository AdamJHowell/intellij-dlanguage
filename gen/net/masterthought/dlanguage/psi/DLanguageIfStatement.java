// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageIfStatement extends PsiElement {

  @Nullable
  DLanguageElseStatement getElseStatement();

  @Nullable
  DLanguageIfCondition getIfCondition();

  @Nullable
  DLanguageThenStatement getThenStatement();

  @Nullable
  PsiElement getKwElse();

  @NotNull
  PsiElement getKwIf();

  @Nullable
  PsiElement getOpParLeft();

  @Nullable
  PsiElement getOpParRight();

  //WARNING: processDeclarations(...) is skipped
  //matching processDeclarations(DLanguageIfStatement, ...)
  //methods are not found in DPsiImplUtil

}
