// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageTemplateArgumentList extends PsiElement {

  @NotNull
  DLanguageTemplateArgument getTemplateArgument();

  @Nullable
  DLanguageTemplateArgumentList getTemplateArgumentList();

  @Nullable
  PsiElement getOpComma();

}
