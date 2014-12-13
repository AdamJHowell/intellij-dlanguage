// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static net.masterthought.dlanguage.psi.DLanguageTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import net.masterthought.dlanguage.psi.*;

public class DLanguageFloatLiteralImpl extends ASTWrapperPsiElement implements DLanguageFloatLiteral {

  public DLanguageFloatLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitFloatLiteral(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<DLanguageDecimalDigits> getDecimalDigitsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageDecimalDigits.class);
  }

  @Override
  @Nullable
  public DLanguageExponentPart getExponentPart() {
    return findChildByClass(DLanguageExponentPart.class);
  }

  @Override
  @Nullable
  public DLanguageFloatTypeSuffix getFloatTypeSuffix() {
    return findChildByClass(DLanguageFloatTypeSuffix.class);
  }

}
