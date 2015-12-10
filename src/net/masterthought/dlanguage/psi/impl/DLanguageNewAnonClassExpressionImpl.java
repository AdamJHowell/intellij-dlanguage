// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static net.masterthought.dlanguage.psi.interfaces.DLanguageTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import net.masterthought.dlanguage.psi.*;

public class DLanguageNewAnonClassExpressionImpl extends ASTWrapperPsiElement implements DLanguageNewAnonClassExpression {

  public DLanguageNewAnonClassExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitNewAnonClassExpression(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DLanguageAggregateBody getAggregateBody() {
    return findNotNullChildByClass(DLanguageAggregateBody.class);
  }

  @Override
  @Nullable
  public DLanguageAllocatorArguments getAllocatorArguments() {
    return findChildByClass(DLanguageAllocatorArguments.class);
  }

  @Override
  @Nullable
  public DLanguageClassArguments getClassArguments() {
    return findChildByClass(DLanguageClassArguments.class);
  }

  @Override
  @Nullable
  public DLanguageInterfaces getInterfaces() {
    return findChildByClass(DLanguageInterfaces.class);
  }

  @Override
  @Nullable
  public DLanguageSuperClass getSuperClass() {
    return findChildByClass(DLanguageSuperClass.class);
  }

  @Override
  @NotNull
  public PsiElement getKwClass() {
    return findNotNullChildByType(KW_CLASS);
  }

  @Override
  @NotNull
  public PsiElement getKwNew() {
    return findNotNullChildByType(KW_NEW);
  }

}
