package net.masterthought.dlanguage.psi.impl;

import com.intellij.lang.ASTNode;
import net.masterthought.dlanguage.psi.interfaces.DDeclarationModule;

public class DDeclarationModuleImpl extends DCompositeElementImpl implements DDeclarationModule{

    public DDeclarationModuleImpl(ASTNode node) {
        super(node);
    }


}
