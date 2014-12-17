// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageCastExpression extends PsiElement {

  @Nullable
  DLanguageCastQualifier getCastQualifier();

  @Nullable
  DLanguageType getType();

  @NotNull
  DLanguageUnaryExpression getUnaryExpression();

  @NotNull
  PsiElement getCast();

  @NotNull
  PsiElement getLParen();

  @NotNull
  PsiElement getRParen();

}
