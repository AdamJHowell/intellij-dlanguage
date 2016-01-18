package net.masterthought.dlanguage.project;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.ParametersList;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessAdapter;
import com.intellij.execution.process.ProcessEvent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import net.masterthought.dlanguage.settings.ToolKey;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DubConfigurationParser {

    private static final Logger LOG = Logger.getInstance("#" + DubConfigurationParser.class.getName());

    private JsonObject dubConfiguration;
    private Project project;
    private String dubBinaryPath;

    public DubConfigurationParser(Project project, String dubBinaryPath) {

        this.project = project;
        this.dubBinaryPath = dubBinaryPath;
        this.dubConfiguration = parseDubConfiguration();
    }

    public class DubPackage {
        public String name;
        public String path;
        public String sourcesDir;

        public DubPackage(String name, String path, String sourcesDir) {
            this.name = name;
            this.path = path;
            this.sourcesDir = sourcesDir;
        }
    }

    public DubPackage getDubPackage() {
        JsonArray packages = dubConfiguration.get("packages").getAsJsonArray();
        List<DubPackage> packageList = new ArrayList<>();
        for (JsonElement pkg : packages) {
            JsonObject thePackage = ((JsonObject) pkg);
            String path = thePackage.get("path").getAsString();
            String name = thePackage.get("name").getAsString();
            String sourcesDir = "source";
            JsonArray importPaths = thePackage.get("importPaths").getAsJsonArray();
            if (importPaths.size() > 0) {
                sourcesDir = importPaths.get(0).getAsString();
            }
            packageList.add(new DubPackage(name, path, sourcesDir));
        }
        return packageList.get(0);
    }

    private JsonObject parseDubConfiguration() {
        try {
            String baseDir = project.getBaseDir().getCanonicalPath();
            GeneralCommandLine commandLine = new GeneralCommandLine();
            commandLine.setWorkDirectory(new File(baseDir));
            commandLine.setExePath(dubBinaryPath);
            ParametersList parametersList = commandLine.getParametersList();
            parametersList.addParametersString("describe");

            OSProcessHandler process = new OSProcessHandler(commandLine.createProcess());

            final StringBuilder builder = new StringBuilder();
            process.addProcessListener(new ProcessAdapter() {
                @Override
                public void onTextAvailable(ProcessEvent event, Key outputType) {
                    builder.append(event.getText());
                }
            });

            process.startNotify();
            process.waitFor();

            // remove the warning line at the top if it exists
            String json = builder.toString().replaceAll("WARNING.+", "").trim();

            // process output of dub describe into jsonObject
            return new JsonParser().parse(json).getAsJsonObject();

        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
