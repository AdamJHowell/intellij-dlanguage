
    package net.masterthought.dlanguage.psi;

    import com.intellij.psi.PsiElement;
    import org.jetbrains.annotations.NotNull;
    import static net.masterthought.dlanguage.psi.DLanguageTypes.*;
    import org.jetbrains.annotations.Nullable;
    import com.intellij.psi.util.PsiTreeUtil;
    import java.util.List;
    import net.masterthought.dlanguage.psi.interfaces.DNamedElement;
    import net.masterthought.dlanguage.psi.interfaces.DCompositeElement;




    public interface DLanguageAsmUnaExp extends PsiElement {
            @Nullable
            public DLanguageAsmUnaExp getAsmUnaExp();
            @Nullable
            public DLanguageIdentifier getIdentifier();
            @Nullable
            public DLanguageAsmExp getAsmExp();
            @Nullable
            public PsiElement getOP_PLUS();
        
            @Nullable
            public PsiElement getOP_MINUS();
        
            @Nullable
            public PsiElement getOP_NOT();
        
            @Nullable
            public PsiElement getOP_TILDA();
        
            @Nullable
            public DLanguageAsmPrimaryExp getAsmPrimaryExp();
}