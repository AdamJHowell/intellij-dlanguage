// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageNewExpression extends PsiElement {

  @Nullable
  DLanguageAllocatorArguments getAllocatorArguments();

  @Nullable
  DLanguageNewExpressionWithArgs getNewExpressionWithArgs();

  @Nullable
  DLanguageType getType();

  @Nullable
  PsiElement getKwNew();

}
