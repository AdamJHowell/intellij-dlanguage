// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageFuncDeclaratorSuffix extends PsiElement {

  @Nullable
  DLanguageConstraint getConstraint();

  @Nullable
  DLanguageMemberFunctionAttributes getMemberFunctionAttributes();

  @NotNull
  DLanguageParameters getParameters();

  @Nullable
  DLanguageTemplateParameters getTemplateParameters();

}
