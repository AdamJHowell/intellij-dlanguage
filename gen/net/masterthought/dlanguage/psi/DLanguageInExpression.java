// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageInExpression extends PsiElement {

  @Nullable
  DLanguageAddExpression_ getAddExpression_();

  @Nullable
  DLanguageMulExpression_ getMulExpression_();

  @Nullable
  DLanguageShiftExpression_ getShiftExpression_();

  @Nullable
  DLanguageUnaryExpression getUnaryExpression();

  @NotNull
  PsiElement getKwIn();

  @Nullable
  PsiElement getOpNot();

}
