// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageAsmPrimaryExp extends PsiElement {

  @Nullable
  DLanguageStringLiteral getStringLiteral();

  @Nullable
  DLanguageIdentifierChain getIdentifierChain();

  @Nullable
  DLanguageRegister getRegister();

  @Nullable
  PsiElement getFloatLiteral();

  @Nullable
  PsiElement getIntegerLiteral();

  @Nullable
  PsiElement getOpDollar();

}
