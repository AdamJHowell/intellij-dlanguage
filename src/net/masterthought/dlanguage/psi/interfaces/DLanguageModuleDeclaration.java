// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageModuleDeclaration extends PsiElement {

  @Nullable
  DLanguageAttribute getAttribute();

  @NotNull
  DLanguageModuleFullyQualifiedName getModuleFullyQualifiedName();

  @NotNull
  PsiElement getKwModule();

  @NotNull
  PsiElement getOpScolon();

}
