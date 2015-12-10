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

public class DLanguageDeclarationBlockImpl extends ASTWrapperPsiElement implements DLanguageDeclarationBlock {

  public DLanguageDeclarationBlockImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DLanguageVisitor) ((DLanguageVisitor)visitor).visitDeclarationBlock(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DLanguageDeclDef getDeclDef() {
    return findChildByClass(DLanguageDeclDef.class);
  }

  @Override
  @Nullable
  public DLanguageDeclDefs getDeclDefs() {
    return findChildByClass(DLanguageDeclDefs.class);
  }

  @Override
  @Nullable
  public PsiElement getOpBracesLeft() {
    return findChildByType(OP_BRACES_LEFT);
  }

  @Override
  @Nullable
  public PsiElement getOpBracesRight() {
    return findChildByType(OP_BRACES_RIGHT);
  }

}
