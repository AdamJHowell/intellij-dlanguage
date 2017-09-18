package net.masterthought.dlanguage.stubs;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.NamedStubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;
import net.masterthought.dlanguage.psi.DlangStructDeclaration;
import net.masterthought.dlanguage.stubs.interfaces.HasMembersStub;

public class DlangStructDeclarationStub extends NamedStubBase<DlangStructDeclaration> implements HasMembersStub {
    public DlangStructDeclarationStub(final StubElement parent, final IStubElementType elementType, final StringRef name) {
        super(parent, elementType, name);
    }

    public DlangStructDeclarationStub(final StubElement parent, final IStubElementType elementType, final String name) {
        super(parent, elementType, name);
    }
}
