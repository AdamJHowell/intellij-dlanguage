package net.masterthought.dlanguage.psi.interfaces;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.psi.stubs.NamedStubBase;
import com.intellij.psi.stubs.Stub;
import com.intellij.psi.stubs.StubElement;
import net.masterthought.dlanguage.psi.DlangFile;
import net.masterthought.dlanguage.psi.DLanguageSharedStaticConstructor;
import net.masterthought.dlanguage.psi.DLanguageSharedStaticDestructor;
import net.masterthought.dlanguage.stubs.*;
import net.masterthought.dlanguage.stubs.interfaces.DLanguageUnittestStub;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by francis on 8/5/2017.
 */
public interface HasMembers<T extends StubElement> extends StubBasedPsiElement<T>, DNamedElement {
    default Set<NamedStubBase> getMembers() {
        final Set<NamedStubBase> res = new HashSet<>();
        ((DlangFile) getContainingFile()).calcStubTree();
        getMembersImpl(((StubBasedPsiElementBase) this).getGreenStub(), res);
        return res;
    }

    default void getMembersImpl(final Stub stub, final Set<NamedStubBase> result) {
        for (final Stub childStub : stub.getChildrenStubs()) {
            if (childStub instanceof NamedStubBase && !(childStub instanceof DlangIdentifierStub)) {
                result.add((NamedStubBase) childStub);
            }
            if (childStub instanceof DLanguageUnittestStub || (childStub instanceof DlangDestructorStub) || (childStub instanceof DlangStaticDestructorStub) || (childStub instanceof DLanguageSharedStaticDestructor) || (childStub instanceof DlangConstructorStub) || (childStub instanceof DlangStaticConstructorStub) || (childStub instanceof DLanguageSharedStaticConstructor) || (childStub instanceof DlangFunctionDeclarationStub) || (childStub instanceof DlangIdentifierStub)) {
            } else {
                getMembersImpl(childStub, result);
            }
        }
    }
}
