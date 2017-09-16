package uk.co.cwspencer.ideagdb.run;

import com.intellij.ide.util.TreeFileChooser;
import com.intellij.ide.util.TreeFileChooserFactory;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.ui.RawCommandLineEditor;
import net.masterthought.dlanguage.DLanguageFileType;
import net.masterthought.dlanguage.GoSdkUtil;
import net.masterthought.dlanguage.psi.DLanguageFile;
import org.jetbrains.annotations.NotNull;
import uk.co.cwspencer.ideagdb.debug.go.GoGdbUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GdbRunConfigurationEditor<T extends GdbRunConfiguration> extends SettingsEditor<T> {
    private static final Logger m_log =
        Logger.getInstance("#uk.co.cwspencer.ideagdb.run.GdbRunConfigurationEditor");

    private TextFieldWithBrowseButton applicationName;
    private RawCommandLineEditor appArguments;
    private TextFieldWithBrowseButton m_gdbPath;
    private RawCommandLineEditor builderArguments;
    private RawCommandLineEditor envVars;
    private JTextArea m_startupCommands;
    private JCheckBox autoStartGdb;
    private JPanel component;
    private JLabel gdbVersionWarning;

    public GdbRunConfigurationEditor(final Project project) {
        applicationName.getButton().addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    TreeFileChooser fileChooser =
                        TreeFileChooserFactory.getInstance(project).createFileChooser(
                            "Go Application Chooser", null,
                            DLanguageFileType.INSTANCE,
                            new TreeFileChooser.PsiFileFilter() {
                                public boolean accept(PsiFile file) {

                                    if (!(file instanceof DLanguageFile)) {
                                        return false;
                                    }

                                    return ((DLanguageFile) file).getMainFunction() != null;
                                }
                            }, true, false);

                    fileChooser.showDialog();

                    PsiFile selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile != null) {
                        setChosenFile(selectedFile.getVirtualFile());
                    }
                }
            });

//        buildDirectoryPathBrowser.addBrowseFolderListener("Go executable build path", "Go executable build path",
//            project, new FileChooserDescriptor(false, true, false, false, false, false));

//        workingDirectoryBrowser.addBrowseFolderListener("Application working directory", "Application working directory",
//            project, new FileChooserDescriptor(false, true, false, false, false, false));

        m_gdbPath.addBrowseFolderListener("GDB executable path", "GDB executable path",
            project, new FileChooserDescriptor(true, false, false, false, false, false));
    }

    @Override
    protected void resetEditorFrom(T configuration) {
        m_gdbPath.setText(configuration.GDB_PATH);
        m_startupCommands.setText(configuration.STARTUP_COMMANDS);
        autoStartGdb.setSelected(configuration.autoStartGdb);

        applicationName.setText(configuration.scriptName);
        appArguments.setText(configuration.scriptArguments);
        if (configuration.builderArguments.isEmpty()) {
            configuration.builderArguments = GoSdkUtil.defualtBuilderArguments;
        }
        builderArguments.setText(configuration.builderArguments);
//        buildBeforeRunCheckBox.setSelected(true);
//        buildDirectoryPathBrowser.setEnabled(true);
//        buildDirectoryPathBrowser.setText(configuration.goOutputDir);
//        workingDirectoryBrowser.setText(configuration.workingDir);
//        if (workingDirectoryBrowser.getText().isEmpty()) {
//            workingDirectoryBrowser.setText(configuration.getProject().getBasePath());
//        }

        envVars.setText(configuration.envVars);
//        runGoVetBeforeCheckBox.setSelected(configuration.goVetEnabled);
    }

    @Override
    protected void applyEditorTo(T configuration) throws ConfigurationException {
        String gdbPath = m_gdbPath.getText();
        if (gdbPath.isEmpty()) {
            throw new ConfigurationException("Please select the path to gdb.");
        } else if (!GoGdbUtil.isValidGdbPath(gdbPath)) {
            throw new ConfigurationException("Please select a valid path to gdb.");
        } else {
            gdbVersionWarning.setVisible(!GoGdbUtil.isKnownGdb(gdbPath));
        }

        if (applicationName.getText().length() == 0)
            throw new ConfigurationException("Please select the file to run.");
//        if (!buildBeforeRunCheckBox.isSelected() || buildDirectoryPathBrowser.getText().equals("")) {
//            throw new ConfigurationException("Please select the directory for the executable.");
//        }

        configuration.GDB_PATH = m_gdbPath.getText();
        if (m_startupCommands != null && m_startupCommands.getText().length() != 0)
            configuration.STARTUP_COMMANDS = m_startupCommands.getText();
        configuration.autoStartGdb = autoStartGdb.isSelected();

        configuration.scriptName = applicationName.getText();
        configuration.scriptArguments = appArguments.getText();
        configuration.builderArguments = builderArguments.getText();
//        configuration.goOutputDir = buildDirectoryPathBrowser.getText();
//        configuration.workingDir = workingDirectoryBrowser.getText();
        configuration.envVars = envVars.getText();
//        configuration.goVetEnabled = runGoVetBeforeCheckBox.isSelected();
    }

    private void setChosenFile(VirtualFile virtualFile) {
        applicationName.setText(virtualFile.getPath());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return component;
    }

    @Override
    protected void disposeEditor() {
        component.setVisible(false);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
