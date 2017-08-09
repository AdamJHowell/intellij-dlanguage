package net.masterthought.dlanguage;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.CapturingProcessHandler;
import com.intellij.execution.process.ProcessOutput;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.projectRoots.*;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.util.SystemInfo;
import net.masterthought.dlanguage.icons.DLanguageIcons;
import net.masterthought.dlanguage.library.LibFileRootType;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Responsible for the mechanics when pressing "+" in the SDK configuration,
 * as well as the project SDK configuration.
 */
public class DLanguageSdkType extends SdkType {

    private static final Logger LOG = Logger.getInstance(DLanguageSdkType.class);

    private static final String SDK_TYPE_ID = "DMD2 SDK";
    private static final String SDK_NAME = "DMD v2 SDK";

    private static final File DEFAULT_SDK_PATH_WINDOWS = new File("c:/D/DMD2/windows/");
    private static final File DEFAULT_SDK_PATH_OSX = new File("/usr/local/opt/dmd");
    private static final File DEFAULT_SDK_PATH_LINUX = new File("/usr/bin");

    private File dmdBinary = null;

    @NotNull
    public static DLanguageSdkType getInstance() {
        final DLanguageSdkType sdkType = SdkType.findInstance(DLanguageSdkType.class);
        return sdkType != null? sdkType : new DLanguageSdkType();
    }

    public DLanguageSdkType() {
        super(SDK_TYPE_ID);
    }

    @NotNull
    @Override
    public Icon getIconForAddAction() {
        return DLanguageIcons.FILE;
    }

    @NotNull
    @Override
    public Icon getIcon() {
        return DLanguageIcons.FILE;
    }

    @Nullable
    @Override
    public String suggestHomePath() {
        String homePath = null;
        if (SystemInfo.isWindows && DEFAULT_SDK_PATH_WINDOWS.exists()) {
            homePath = DEFAULT_SDK_PATH_WINDOWS.getAbsolutePath();
        } else if (SystemInfo.isMac && DEFAULT_SDK_PATH_OSX.exists()) {
            homePath = DEFAULT_SDK_PATH_OSX.getAbsolutePath();
        } else if (SystemInfo.isLinux && DEFAULT_SDK_PATH_LINUX.exists()) {
            homePath = DEFAULT_SDK_PATH_LINUX.getAbsolutePath();
        }
        LOG.debug(String.format("Suggested DMD path: %s", homePath));
        return homePath;
    }

    /* When user set up DMD SDK path this method checks if specified path contains DMD compiler executable. */
    @Override
    public boolean isValidSdkHome(final String sdkHome) {
        final String executableName = SystemInfo.isWindows ? "dmd.exe" : "dmd";

        File dmdBinary = new File(sdkHome, executableName);

        if(dmdBinary.exists() && dmdBinary.canExecute()) {
            this.dmdBinary = dmdBinary;
            return true;
        }

        if(SystemInfo.isWindows) {
            final File dmdHome = new File(sdkHome);
            if(dmdHome.exists() && dmdHome.isDirectory()) {
                dmdBinary = Paths.get(sdkHome, "bin", executableName).toFile(); // C:\D\dmd2\windows\bin\dmd.exe
            }
        }

        if(dmdBinary.exists() && dmdBinary.canExecute()) {
            this.dmdBinary = dmdBinary;
            return true;
        }
        return false;
    }

    @Override
    public String suggestSdkName(final String currentSdkName, final String sdkHome) {
        final String version = getDmdVersion(sdkHome);
        return version != null? version : SDK_NAME;
    }

    @Nullable
    @Override
    public String getVersionString(@NotNull final String sdkHome) {
        final String version = getDmdVersion(sdkHome);

        if(version != null) {
            final Matcher m = Pattern.compile(".*v(\\d+\\.\\d+).*").matcher(version);
            if(m.matches()) {
                return m.group(1);
            }
        }

        return "2.0";
    }

    @Nullable
    @Override
    public AdditionalDataConfigurable createAdditionalDataConfigurable(final SdkModel sdkModel,
                                                                       final SdkModificator sdkModificator) {
        return null;
    }

    @Override
    public String getPresentableName() {
        return "Digital Mars D compiler";
    }

    @Override
    public void saveAdditionalData(@NotNull final SdkAdditionalData sdkAdditionalData,
                                   @NotNull final Element element) {
        //pass
    }

    @Override
    public boolean isRootTypeApplicable(final OrderRootType type) {
        return type != LibFileRootType.getInstance() && super.isRootTypeApplicable(type);
    }

    /**
     * Try to execute 'dmd --version' and return first line of the output.
     * @param sdkHome path to dmd home directory
     * @return String containing DMD version or null
     */
    @Nullable
    private String getDmdVersion(final String sdkHome) {
        final File compilerFolder = new File(sdkHome);
        final File compilerFile = new File(sdkHome, SystemInfo.isWindows ? "dmd.exe" : "dmd");

        final GeneralCommandLine commandLine = new GeneralCommandLine();
        commandLine.withWorkDirectory(compilerFolder.getAbsolutePath());
        commandLine.setExePath(compilerFile.getAbsolutePath());
        commandLine.addParameter("--version");

        try {
            final ProcessOutput output = new CapturingProcessHandler(
                commandLine.createProcess(),
                Charset.defaultCharset(),
                commandLine.getCommandLineString()
            ).runProcess();

            //Parse output of a DMD compiler
            final List<String> outputLines = output.getStdoutLines();
            if(outputLines != null && !outputLines.isEmpty()) {
                final String version = outputLines.get(0).trim();
                LOG.debug(String.format("Found version: %s", version));
                return version;
            }
        } catch (final ExecutionException e) {
            LOG.error("There was a problem running 'dmd --version'", e);
        }
        return null;
    }

    /* Returns full path to DMD compiler executable */
    public String getDmdPath(@NotNull final Sdk sdk) {
        final String homePath = sdk.getHomePath();

        if(isValidSdkHome(homePath)) {
            return dmdBinary.getAbsolutePath();
        }

        return "dmd"; // it may just be on the PATH
    }

    /* Returns full path to DMD compiler sources */
//    public static String getDmdSourcesPaths(final Sdk sdk) {
//        final String sdkHome = sdk.getHomePath();
//        final String executableName = SystemInfo.isWindows ? "dmd.exe" : "dmd";
//        final File dmdCompilerFile = new File(sdkHome, executableName);
//        return dmdCompilerFile.getAbsolutePath();
//    }
}


