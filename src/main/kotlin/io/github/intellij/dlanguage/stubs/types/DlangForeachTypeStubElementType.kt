package io.github.intellij.dlanguage.stubs.types

import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import io.github.intellij.dlanguage.psi.DLanguageForeachType
import io.github.intellij.dlanguage.psi.impl.named.DLanguageForeachTypeImpl
import io.github.intellij.dlanguage.stubs.DlangForeachTypeStub
import java.io.IOException

/**
 * Created by francis on 6/13/2017.
 */
class DlangForeachTypeStubElementType(debugName: String) : io.github.intellij.dlanguage.stubs.types.DNamedStubElementType<DlangForeachTypeStub, io.github.intellij.dlanguage.psi.DLanguageForeachType>(debugName) {

    override fun createPsi(stub: DlangForeachTypeStub): io.github.intellij.dlanguage.psi.DLanguageForeachType {
        return io.github.intellij.dlanguage.psi.impl.named.DLanguageForeachTypeImpl(stub, this)
    }

    override fun createStub(psi: io.github.intellij.dlanguage.psi.DLanguageForeachType, parentStub: StubElement<*>): DlangForeachTypeStub {
        return DlangForeachTypeStub(parentStub, this, psi.name)
    }

    @Throws(IOException::class)
    override fun serialize(stub: DlangForeachTypeStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    @Throws(IOException::class)
    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>): DlangForeachTypeStub {
        return DlangForeachTypeStub(parentStub, this, dataStream.readName()!!)
    }
}
