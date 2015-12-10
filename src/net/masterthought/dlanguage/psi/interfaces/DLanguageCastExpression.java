// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageCastExpression extends PsiElement {

  @Nullable
  DLanguageType getType();

  @Nullable
  DLanguageTypeCtors getTypeCtors();

  @NotNull
  DLanguageUnaryExpression getUnaryExpression();

  @NotNull
  PsiElement getKwCast();

  @NotNull
  PsiElement getOpParLeft();

  @NotNull
  PsiElement getOpParRight();

}
