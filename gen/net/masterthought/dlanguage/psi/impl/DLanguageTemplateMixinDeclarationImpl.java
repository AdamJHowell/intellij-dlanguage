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

public class DLanguageTemplateMixinDeclarationImpl extends ASTWrapperPsiElement implements DLanguageTemplateMixinDeclaration {

  public DLanguageTemplateMixinDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitTemplateMixinDeclaration(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DLanguageConstraint getConstraint() {
    return findChildByClass(DLanguageConstraint.class);
  }

  @Override
  @Nullable
  public DLanguageDeclDefs getDeclDefs() {
    return findChildByClass(DLanguageDeclDefs.class);
  }

  @Override
  @NotNull
  public DLanguageIdentifier getIdentifier() {
    return findNotNullChildByClass(DLanguageIdentifier.class);
  }

  @Override
  @NotNull
  public DLanguageTemplateParameters getTemplateParameters() {
    return findNotNullChildByClass(DLanguageTemplateParameters.class);
  }

  @Override
  @NotNull
  public PsiElement getKwMixin() {
    return findNotNullChildByType(KW_MIXIN);
  }

  @Override
  @NotNull
  public PsiElement getKwTemplate() {
    return findNotNullChildByType(KW_TEMPLATE);
  }

  @Override
  @NotNull
  public PsiElement getOpBracesLeft() {
    return findNotNullChildByType(OP_BRACES_LEFT);
  }

  @Override
  @NotNull
  public PsiElement getOpBracesRight() {
    return findNotNullChildByType(OP_BRACES_RIGHT);
  }

}
