

package net.masterthought.dlanguage.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.masterthought.dlanguage.psi.*;
import java.util.List;
import static net.masterthought.dlanguage.psi.DLanguageTypes.*;


public class DLanguageConditionalDeclarationImpl extends ASTWrapperPsiElement implements DLanguageConditionalDeclaration{
       public DLanguageConditionalDeclarationImpl (ASTNode node){
               super(node);
       }
       public void accept(@NotNull DLanguageVisitor visitor){
           visitor.visitConditionalDeclaration(this);
       }
       public void accept(@NotNull PsiElementVisitor visitor){
           if(visitor instanceof DLanguageVisitor) accept((DLanguageVisitor)visitor);
           else super.accept(visitor);
       }

            @Nullable
            public DLanguageCompileCondition getCompileCondition() {
                return PsiTreeUtil.getChildOfType(this, DLanguageCompileCondition.class);
            }
                @NotNull
                public List<DLanguageDeclaration> getDeclarations() {
                    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageDeclaration.class);
                }
            @Nullable
            public PsiElement getOP_COLON() {
                return findChildByType(OP_COLON);
            }
        
            @Nullable
            public PsiElement getKW_ELSE() {
                return findChildByType(KW_ELSE);
            }
        
}