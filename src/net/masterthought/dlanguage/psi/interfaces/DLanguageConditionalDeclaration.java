// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.interfaces;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageConditionalDeclaration extends PsiElement {

  @NotNull
  DLanguageCondition getCondition();

  @Nullable
  DLanguageDeclDefs getDeclDefs();

  @NotNull
  List<DLanguageDeclarationBlock> getDeclarationBlockList();

  @Nullable
  PsiElement getKwElse();

  @Nullable
  PsiElement getOpColon();

}
