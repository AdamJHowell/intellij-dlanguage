// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageAndExxpression_ extends PsiElement {

  @Nullable
  DLanguageAddExpression_ getAddExpression_();

  @Nullable
  DLanguageAndExxpression_ getAndExxpression_();

  @Nullable
  DLanguageCastExpression getCastExpression();

  @Nullable
  DLanguageDeleteExpression getDeleteExpression();

  @Nullable
  DLanguageIdentifier getIdentifier();

  @Nullable
  DLanguageMulExpression_ getMulExpression_();

  @Nullable
  DLanguagePostfixExpression getPostfixExpression();

  @Nullable
  DLanguagePowExpression_ getPowExpression_();

  @Nullable
  DLanguageShiftExpression_ getShiftExpression_();

  @Nullable
  DLanguageTemplateInstance getTemplateInstance();

  @Nullable
  DLanguageType getType();

  @Nullable
  DLanguageTypeCtor getTypeCtor();

  @Nullable
  PsiElement getOpDot();

  @Nullable
  PsiElement getOpParLeft();

  @Nullable
  PsiElement getOpParRight();

}
