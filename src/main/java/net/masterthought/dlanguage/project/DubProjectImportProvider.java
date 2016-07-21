package net.masterthought.dlanguage.project;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.ProjectJdkForModuleStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.projectImport.ProjectImportProvider;
import net.masterthought.dlanguage.DLanguageSdkType;
import net.masterthought.dlanguage.module.DubBinaryForModuleStep;
import net.masterthought.dlanguage.module.DubInitForModuleStep;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DubProjectImportProvider extends ProjectImportProvider {

    public DubProjectImportProvider(final DubProjectImportBuilder builder) {
        super(builder);
    }

    @Override
    public ModuleWizardStep[] createSteps(WizardContext wizardContext) {
        List<ModuleWizardStep> steps = new ArrayList<>();

        ModuleWizardStep setDubBinary = new DubBinaryForModuleStep(wizardContext);
        steps.add(setDubBinary);

        return steps.toArray(new ModuleWizardStep[steps.size()]);
    }

    @Override
    public boolean canImport(VirtualFile fileOrDirectory, @Nullable Project project) {
        // If we're not importing a directory, validate it as a file.
        if (!fileOrDirectory.isDirectory()) return canImportFromFile(fileOrDirectory);

        VirtualFile dubFile = fileOrDirectory.findChild("dub.json");
        if(dubFile != null){
            if(canImportFromFile(dubFile)) return true;
        }
        VirtualFile[] dubFiles = fileOrDirectory.getChildren();
        List<Boolean> vfiles = new ArrayList<>();
        for(VirtualFile vfile : dubFiles){
            if(!vfile.isDirectory() && vfile.getName().equals("dub.json")) {
                vfiles.add(canImportFromFile(vfile));
            }
        }
        return !vfiles.contains(false);
    }

    @Override
    public boolean canImportFromFile(VirtualFile file) {
        return true;
    }
}