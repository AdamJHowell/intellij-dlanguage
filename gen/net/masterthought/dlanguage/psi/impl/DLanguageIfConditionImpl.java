// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.impl;

import net.masterthought.dlanguage.psi.interfaces.DLanguageIdentifier;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static net.masterthought.dlanguage.psi.DLanguageTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import net.masterthought.dlanguage.psi.*;

public class DLanguageIfConditionImpl extends ASTWrapperPsiElement implements DLanguageIfCondition {

  public DLanguageIfConditionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitIfCondition(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DLanguageBasicType getBasicType() {
    return findChildByClass(DLanguageBasicType.class);
  }

  @Override
  @Nullable
  public DLanguageDeclarator getDeclarator() {
    return findChildByClass(DLanguageDeclarator.class);
  }

  @Override
  @NotNull
  public DLanguageExpression getExpression() {
    return findNotNullChildByClass(DLanguageExpression.class);
  }

  @Override
  @Nullable
  public DLanguageIdentifier getIdentifier() {
    return findChildByClass(DLanguageIdentifier.class);
  }

  @Override
  @Nullable
  public DLanguageTypeCtors getTypeCtors() {
    return findChildByClass(DLanguageTypeCtors.class);
  }

  @Override
  @Nullable
  public PsiElement getKwAuto() {
    return findChildByType(KW_AUTO);
  }

  @Override
  @Nullable
  public PsiElement getOpEq() {
    return findChildByType(OP_EQ);
  }

}
