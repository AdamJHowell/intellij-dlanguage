// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageAsmShiftExp extends PsiElement {

  @NotNull
  List<DLanguageAsmAddExp> getAsmAddExpList();

  @Nullable
  PsiElement getShiftLeft();

  @Nullable
  PsiElement getShiftRight();

  @Nullable
  PsiElement getUnsignedShiftRight();

}
