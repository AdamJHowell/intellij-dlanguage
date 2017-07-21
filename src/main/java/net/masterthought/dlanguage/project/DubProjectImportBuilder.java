package net.masterthought.dlanguage.project;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.ModifiableModuleModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleWithNameAlreadyExists;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.impl.SdkConfigurationUtil;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.Pair;
import com.intellij.packaging.artifacts.ModifiableArtifactModel;
import com.intellij.projectImport.ProjectImportBuilder;
import net.masterthought.dlanguage.icons.DLanguageIcons;
import net.masterthought.dlanguage.DLanguageSdkType;
import net.masterthought.dlanguage.module.DLanguageDubModuleBuilder;
import org.jdom.JDOMException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DubProjectImportBuilder extends ProjectImportBuilder<DubPackage> {

    private static final Logger LOG = Logger.getInstance("#" + DubProjectImportBuilder.class.getName());

    public void setRootDirectory(final String path) {

    }

    public static class Parameters {
        public List<DubPackage> packages;
        public boolean openModuleSettings = false;
        public String dubBinary;
    }

    public Parameters parameters;

    @NotNull
    public Parameters getParameters() {
        if (parameters == null) {
            parameters = new Parameters();
        }
        return parameters;
    }

    @NotNull
    @Override
    public String getName() {
        return "Dub";
    }

    @Override
    public Icon getIcon() {
        return DLanguageIcons.MODULE;
    }

    @Override
    public List<DubPackage> getList() {
        return getParameters().packages;
    }

    @Override
    public void setList(final List<DubPackage> list) throws ConfigurationException {
        getParameters().packages = list;
    }

    public boolean isOpenProjectSettingsAfter() {
        return getParameters().openModuleSettings;
    }

    public void setOpenProjectSettingsAfter(final boolean on) {
        getParameters().openModuleSettings = on;
    }

    @Override
    public boolean isMarked(final DubPackage dubPackage) {
        return getList().contains(dubPackage);
    }


    @Nullable
    @Override
    public List<Module> commit(final Project project,
                               final ModifiableModuleModel modifiableModuleModel,
                               final ModulesProvider modulesProvider,
                               final ModifiableArtifactModel modifiableArtifactModel) {
        final List<Module> modules = new ArrayList<>();
        final Project myProject = project;
        ModifiableModuleModel moduleModelCandidate = modifiableModuleModel;
        if (moduleModelCandidate == null) {
            moduleModelCandidate = ModuleManager.getInstance(project).getModifiableModel();
        }
        final ModifiableModuleModel moduleModel = moduleModelCandidate;
        ApplicationManager.getApplication().runWriteAction(new Runnable() {
            @Override
            public void run() {
                commitSdk(myProject);
                modules.addAll(buildModules(myProject, moduleModel));
            }
        });
        return modules;
    }

    private List<Module> buildModules(final Project project,
                                      final ModifiableModuleModel moduleModel) {
        final List<Module> moduleList = new ArrayList<>();
        final DubConfigurationParser dubConfigurationParser = new DubConfigurationParser(project, getParameters().dubBinary);
        final DubPackage pkg = dubConfigurationParser.getDubPackage().get();

        final DLanguageDubModuleBuilder builder = new DLanguageDubModuleBuilder();
        builder.setModuleFilePath(pkg.getPath() + pkg.getName() + ".iml");
        builder.setContentEntryPath(pkg.getPath());
        builder.setName(pkg.getName());
        builder.addSourcePath(Pair.create(pkg.getPath() + pkg.getSourcesDir(), ""));

        try {
            final Module module = builder.createModule(moduleModel);
            builder.commit(project);
            moduleList.add(module);
        } catch (InvalidDataException | IOException | JDOMException | ModuleWithNameAlreadyExists | ConfigurationException e) {
            LOG.error(e);
        }
        return moduleList;
    }

    private void commitSdk(final Project project) {
        ProjectRootManager.getInstance(project).setProjectSdk(findOrCreateSdk());
    }

    private Sdk findOrCreateSdk() {
        final DLanguageSdkType sdkType = DLanguageSdkType.getInstance();

        final Comparator<Sdk> sdkComparator = (sdk1, sdk2) -> {
            if (sdk1.getSdkType() == sdkType) {
                return -1;
            } else if (sdk2.getSdkType() == sdkType) {
                return 1;
            } else {
                return 0;
            }
        };
        return SdkConfigurationUtil.findOrCreateSdk(sdkComparator, sdkType);
    }
}
