// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageVersionSpecification extends PsiElement {

  @Nullable
  DLanguageIdentifier getIdentifier();

  @Nullable
  PsiElement getIntegerLiteral();

  @NotNull
  PsiElement getKwVersion();

  @NotNull
  PsiElement getOpEq();

  @NotNull
  PsiElement getOpScolon();

}
