// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageAssignExpression extends PsiElement {

  @Nullable
  DLanguageAssignExpression getAssignExpression();

  @NotNull
  DLanguageConditionalExpression getConditionalExpression();

  @Nullable
  PsiElement getOpAndEq();

  @Nullable
  PsiElement getOpDivEq();

  @Nullable
  PsiElement getOpEq();

  @Nullable
  PsiElement getOpMinusEq();

  @Nullable
  PsiElement getOpModEq();

  @Nullable
  PsiElement getOpMulEq();

  @Nullable
  PsiElement getOpOrEq();

  @Nullable
  PsiElement getOpPlusEq();

  @Nullable
  PsiElement getOpPowEq();

  @Nullable
  PsiElement getOpShLeftEq();

  @Nullable
  PsiElement getOpShRightEq();

  @Nullable
  PsiElement getOpTildaEq();

  @Nullable
  PsiElement getOpUshRightEq();

  @Nullable
  PsiElement getOpXorEq();

}
