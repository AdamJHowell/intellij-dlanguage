// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguagePragma extends PsiElement {

  @Nullable
  DLanguageArgumentList getArgumentList();

  @NotNull
  DLanguageIdentifier getIdentifier();

  @NotNull
  PsiElement getKwPragma();

  @Nullable
  PsiElement getOpComma();

  @NotNull
  PsiElement getOpParLeft();

  @NotNull
  PsiElement getOpParRight();

}
