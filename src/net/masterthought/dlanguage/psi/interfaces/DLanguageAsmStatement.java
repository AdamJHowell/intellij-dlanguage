// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageAsmStatement extends PsiElement {

  @Nullable
  DLanguageAsmInstructionList getAsmInstructionList();

  @Nullable
  DLanguageFunctionAttributes getFunctionAttributes();

  @NotNull
  PsiElement getKwAsm();

  @NotNull
  PsiElement getOpBracesLeft();

  @NotNull
  PsiElement getOpBracesRight();

}
