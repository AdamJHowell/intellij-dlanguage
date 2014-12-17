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

public class DLanguageCastExpressionImpl extends ASTWrapperPsiElement implements DLanguageCastExpression {

  public DLanguageCastExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitCastExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DLanguageCastQualifier getCastQualifier() {
    return findChildByClass(DLanguageCastQualifier.class);
  }

  @Override
  @Nullable
  public DLanguageType getType() {
    return findChildByClass(DLanguageType.class);
  }

  @Override
  @NotNull
  public DLanguageUnaryExpression getUnaryExpression() {
    return findNotNullChildByClass(DLanguageUnaryExpression.class);
  }

  @Override
  @NotNull
  public PsiElement getCast() {
    return findNotNullChildByType(CAST);
  }

  @Override
  @NotNull
  public PsiElement getLParen() {
    return findNotNullChildByType(LPAREN);
  }

  @Override
  @NotNull
  public PsiElement getRParen() {
    return findNotNullChildByType(RPAREN);
  }

}
