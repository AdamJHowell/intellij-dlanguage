// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import net.masterthought.dlanguage.psi.interfaces.DLanguageIdentifier;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageDotIdentifier extends PsiElement {

  @Nullable
  DLanguageDotIdentifier getDotIdentifier();

  @NotNull
  DLanguageIdentifier getIdentifier();

  @Nullable
  PsiElement getOpDot();

}
