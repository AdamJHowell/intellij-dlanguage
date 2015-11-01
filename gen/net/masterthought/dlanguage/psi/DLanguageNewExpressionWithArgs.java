// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageNewExpressionWithArgs extends PsiElement {

  @Nullable
  DLanguageAllocatorArguments getAllocatorArguments();

  @Nullable
  DLanguageArgumentList getArgumentList();

  @Nullable
  DLanguageAssignExpression getAssignExpression();

  @Nullable
  DLanguageNewAnonClassExpression getNewAnonClassExpression();

  @Nullable
  DLanguageType getType();

  @Nullable
  PsiElement getKwNew();

  @Nullable
  PsiElement getOpBracketLeft();

  @Nullable
  PsiElement getOpBracketRight();

  @Nullable
  PsiElement getOpParLeft();

  @Nullable
  PsiElement getOpParRight();

}
