// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageAutoDeclarationY extends PsiElement {

  @NotNull
  DLanguageIdentifier getIdentifier();

  @NotNull
  DLanguageInitializer getInitializer();

  @Nullable
  DLanguageTemplateParameters getTemplateParameters();

  @NotNull
  PsiElement getOpEq();

}
