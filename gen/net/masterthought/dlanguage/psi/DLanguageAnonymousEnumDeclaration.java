// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageAnonymousEnumDeclaration extends PsiElement {

  @Nullable
  DLanguageEnumBaseType getEnumBaseType();

  @NotNull
  DLanguageEnumMembers getEnumMembers();

  @NotNull
  PsiElement getKwEnum();

  @NotNull
  PsiElement getOpBracesLeft();

  @NotNull
  PsiElement getOpBracesRight();

  @Nullable
  PsiElement getOpColon();

}
