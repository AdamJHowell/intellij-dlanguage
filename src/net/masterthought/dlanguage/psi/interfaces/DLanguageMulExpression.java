// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageMulExpression extends PsiElement {

  @Nullable
  DLanguageMulExpression getMulExpression();

  @NotNull
  DLanguageUnaryExpression getUnaryExpression();

  @Nullable
  PsiElement getOpAsterisk();

  @Nullable
  PsiElement getOpDiv();

  @Nullable
  PsiElement getOpMod();

}
