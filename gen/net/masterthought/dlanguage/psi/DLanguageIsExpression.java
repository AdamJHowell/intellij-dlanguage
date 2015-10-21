// This is a generated file. Not intended for manual editing.
package net.masterthought.dlanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DLanguageIsExpression extends PsiElement {

  @NotNull
  List<DLanguageIdentifier> getIdentifierList();

  @NotNull
  List<DLanguageTemplateParameterList> getTemplateParameterListList();

  @NotNull
  List<DLanguageType> getTypeList();

  @NotNull
  List<DLanguageTypeSpecialization> getTypeSpecializationList();

}
