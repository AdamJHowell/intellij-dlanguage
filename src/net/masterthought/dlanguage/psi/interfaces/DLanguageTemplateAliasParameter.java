// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageTemplateAliasParameter extends PsiElement {

  @NotNull
  List<DLanguageAssignExpression> getAssignExpressionList();

  @Nullable
  DLanguageIdentifier getIdentifier();

  @NotNull
  List<DLanguageType> getTypeList();

  @NotNull
  PsiElement getKwAlias();

  @Nullable
  PsiElement getOpColon();

  @Nullable
  PsiElement getOpEq();

}
