// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageTemplateSingleArgument extends PsiElement {

  @Nullable
  DLanguageAssignExpression getAssignExpression();

  @Nullable
  DLanguageBasicTypeX getBasicTypeX();

  @Nullable
  DLanguageIdentifier getIdentifier();

  @Nullable
  DLanguageSpecialKeyword getSpecialKeyword();

  @Nullable
  DLanguageStringLiteral getStringLiteral();

  @Nullable
  PsiElement getCharacterLiteral();

  @Nullable
  PsiElement getFloatLiteral();

  @Nullable
  PsiElement getIntegerLiteral();

  @Nullable
  PsiElement getKwFalse();

  @Nullable
  PsiElement getKwNull();

  @Nullable
  PsiElement getKwThis();

  @Nullable
  PsiElement getKwTrue();

}
