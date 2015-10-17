// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageInterfaceDeclaration extends PsiElement {

  @NotNull
  DLanguageIdentifier getIdentifier();

  @Nullable
  DLanguageBaseClassList getBaseClassList();

  @Nullable
  DLanguageConstraint getConstraint();

  @Nullable
  DLanguageStructBody getStructBody();

  @Nullable
  DLanguageTemplateParameters getTemplateParameters();

  @NotNull
  PsiElement getKwInterface();

  @Nullable
  PsiElement getOpColon();

  @Nullable
  PsiElement getOpScolon();

}
