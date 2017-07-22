package net.masterthought.dlanguage.psi.impl.named;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import net.masterthought.dlanguage.psi.*;
import net.masterthought.dlanguage.psi.impl.DNamedStubbedPsiElementBase;
import net.masterthought.dlanguage.psi.references.DReference;
import net.masterthought.dlanguage.resolve.ScopeProcessorImpl;
import net.masterthought.dlanguage.stubs.DLanguageDeclaratorStub;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.masterthought.dlanguage.psi.DLanguageTypes.OP_EQ;


public class DLanguageDeclaratorImpl extends DNamedStubbedPsiElementBase<DLanguageDeclaratorStub> implements DLanguageDeclarator {
    public DLanguageDeclaratorImpl(ASTNode node) {
        super(node);
    }

    public DLanguageDeclaratorImpl(@NotNull DLanguageDeclaratorStub stub, IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public void accept(@NotNull DLanguageVisitor visitor) {
        visitor.visitDeclarator(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof DLanguageVisitor) accept((DLanguageVisitor) visitor);
        else super.accept(visitor);
    }

    @Nullable
    public DLanguageIdentifier getIdentifier() {
        return PsiTreeUtil.getChildOfType(this, DLanguageIdentifier.class);
    }

    @Nullable
    public PsiElement getOP_EQ() {
        return findChildByType(OP_EQ);
    }

    @Nullable
    public DLanguageTemplateParameters getTemplateParameters() {
        return PsiTreeUtil.getChildOfType(this, DLanguageTemplateParameters.class);
    }

    @Nullable
    public DLanguageInitializer getInitializer() {
        return PsiTreeUtil.getChildOfType(this, DLanguageInitializer.class);
    }

    @NotNull
    @Override
    public String getName() {
        if (getStub() != null) {
            return getStub().getName();
        }
        if(getIdentifier() == null){
            return DReference.Companion.getNAME_NOT_FOUND_STRING();
        }
        return getIdentifier().getName();
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return getIdentifier().setName(name);
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
        return ScopeProcessorImpl.INSTANCE.processDeclarations(this,processor, state, lastParent, place);
    }
}
