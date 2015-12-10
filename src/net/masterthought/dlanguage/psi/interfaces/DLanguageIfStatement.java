// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageIfStatement extends PsiElement {

  @Nullable
  DLanguageElseStatement getElseStatement();

  @NotNull
  DLanguageIfCondition getIfCondition();

  @NotNull
  DLanguageThenStatement getThenStatement();

  @Nullable
  PsiElement getKwElse();

  @NotNull
  PsiElement getKwIf();

  @NotNull
  PsiElement getOpParLeft();

  @NotNull
  PsiElement getOpParRight();

}
