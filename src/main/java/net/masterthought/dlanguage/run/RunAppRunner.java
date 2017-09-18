package net.masterthought.dlanguage.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.DefaultProgramRunner;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import net.masterthought.dlanguage.run.exception.ModuleNotFoundException;
import net.masterthought.dlanguage.run.exception.NoValidDlangSdkFound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RunAppRunner extends DefaultProgramRunner {
    @NotNull
    @Override
    public String getRunnerId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
        return (DefaultDebugExecutor.EXECUTOR_ID.equals(executorId) || DefaultRunExecutor.EXECUTOR_ID.equals(executorId)) &&
            profile instanceof DlangRunAppConfiguration;
    }

    @Nullable
    @Override
    protected RunContentDescriptor doExecute(RunProfileState state, ExecutionEnvironment env) throws ExecutionException {
        if (env.getExecutor().getActionName().equals(DefaultDebugExecutor.EXECUTOR_ID)) {
            Project project = env.getProject();

            Executor executor = env.getExecutor();
            Logger logger = Logger.getInstance(this.getClass());
            try {
                return RunUtil.startDebugger(this, state, env, project, executor, ((DlangRunAppState) state).getExecutableCommandLine(((DlangRunAppState) state).getConfig()).getExePath());//todo this is yucky
            } catch (ModuleNotFoundException e) {
                e.printStackTrace();
                logger.error(e.toString());
            } catch (NoValidDlangSdkFound NoValidDlangSdkFound) {
                NoValidDlangSdkFound.printStackTrace();
                logger.error(NoValidDlangSdkFound.toString());
            }
        }
        return super.doExecute(state, env);
    }
}
