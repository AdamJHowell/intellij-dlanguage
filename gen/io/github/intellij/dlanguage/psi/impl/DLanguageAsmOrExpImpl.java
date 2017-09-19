package io.github.intellij.dlanguage.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.github.intellij.dlanguage.psi.DLanguageAsmXorExp;
import io.github.intellij.dlanguage.psi.DlangTypes;
import io.github.intellij.dlanguage.psi.DlangVisitor;
import io.github.intellij.dlanguage.psi.DLanguageAsmOrExp;
import io.github.intellij.dlanguage.psi.DLanguageAsmXorExp;
import io.github.intellij.dlanguage.psi.DlangVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static io.github.intellij.dlanguage.psi.DlangTypes.OP_OR;


public class DLanguageAsmOrExpImpl extends ASTWrapperPsiElement implements DLanguageAsmOrExp {
    public DLanguageAsmOrExpImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull DlangVisitor visitor) {
        visitor.visitAsmOrExp(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof DlangVisitor) accept((DlangVisitor) visitor);
        else super.accept(visitor);
    }

    @Nullable
    public DLanguageAsmOrExp getAsmOrExp() {
        return PsiTreeUtil.getChildOfType(this, DLanguageAsmOrExp.class);
    }

    @Nullable
    public DLanguageAsmXorExp getAsmXorExp() {
        return PsiTreeUtil.getChildOfType(this, DLanguageAsmXorExp.class);
    }

    @Nullable
    public PsiElement getOP_OR() {
        return findChildByType(DlangTypes.OP_OR);
    }

}
