package io.github.intellij.dlanguage.psi.impl.named;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import io.github.intellij.dlanguage.psi.*;
import io.github.intellij.dlanguage.psi.references.DReference;
import io.github.intellij.dlanguage.stubs.DlangModuleDeclarationStub;
import io.github.intellij.dlanguage.icons.DlangIcons;
import io.github.intellij.dlanguage.psi.*;
import io.github.intellij.dlanguage.psi.impl.DElementFactory;
import io.github.intellij.dlanguage.psi.impl.DNamedStubbedPsiElementBase;
import io.github.intellij.dlanguage.psi.references.DReference;
import io.github.intellij.dlanguage.stubs.DlangModuleDeclarationStub;
import io.github.intellij.dlanguage.utils.DUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

import static io.github.intellij.dlanguage.psi.DlangTypes.KW_MODULE;
import static io.github.intellij.dlanguage.psi.DlangTypes.OP_SCOLON;

public class DLanguageModuleDeclarationImpl extends DNamedStubbedPsiElementBase<DlangModuleDeclarationStub> implements DLanguageModuleDeclaration {

    public DLanguageModuleDeclarationImpl(final DlangModuleDeclarationStub stub, final IStubElementType type) {
        super(stub, type);
    }

    public DLanguageModuleDeclarationImpl(final ASTNode node) {
        super(node);
    }

    public void accept(@NotNull final DlangVisitor visitor) {
        visitor.visitModuleDeclaration(this);
    }

    public void accept(@NotNull final PsiElementVisitor visitor) {
        if (visitor instanceof DlangVisitor) accept((DlangVisitor) visitor);
        else super.accept(visitor);
    }

    @NotNull
    public String getName() {
        if (getStub() != null) {
            return getStub().getName();
        }
        if (getIdentifierChain() == null) {
            return DReference.Companion.getNAME_NOT_FOUND_STRING();
        }
        return getIdentifierChain().getText();
    }

    @Nullable
    public DlangIdentifier getNameIdentifier() {
        return DUtil.getEndOfIdentifierList(getIdentifierChain());
    }

    @NotNull
    public PsiReference getReference() {
        return new DReference(this, TextRange.from(0, (this).getName().length()));
    }

    @NotNull
    public PsiElement setName(@NotNull final String newName) {
        return this.replace(DElementFactory.createDLanguageModuleFromText(this.getProject(), newName));
    }

    @NotNull
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @NotNull
            @Override
            public String getPresentableText() {
                return getName();
            }

            /**
             * This is needed to decipher between files when resolving multiple references.
             */
            @Nullable
            @Override
            public String getLocationString() {
                final PsiFile psiFile = getContainingFile();
                return psiFile instanceof DlangFile ? ((DlangFile) psiFile).getModuleOrFileName() : null;
            }

            @Nullable
            @Override
            public Icon getIcon(final boolean unused) {
                return DlangIcons.FILE;
            }
        };
    }

    @Nullable
    @Override
    public PsiElement getKW_MODULE() {
        return findChildByType(DlangTypes.KW_MODULE);
    }

    @Nullable
    @Override
    public DLanguageIdentifierChain getIdentifierChain() {
        return PsiTreeUtil.getChildOfType(this, DLanguageIdentifierChain.class);
    }

    @Nullable
    @Override
    public PsiElement getOP_SCOLON() {
        return findChildByType(DlangTypes.OP_SCOLON);
    }
}
