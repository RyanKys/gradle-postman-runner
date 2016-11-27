package de.infonautika.postman.task;

import org.apache.commons.io.FileUtils;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static de.infonautika.postman.PostmanExtension.getWrapperName;
import static de.infonautika.postman.PostmanRunnerPlugin.GROUP_NAME;

public class DeployPostmanWrapperTask extends AbstractPostmanRunnerTask {
    public final static String NAME = "deployWrapper";

    public DeployPostmanWrapperTask() {
        setGroup(GROUP_NAME);
        setDescription("executes Postman collections");
    }

    @TaskAction
    public void createNewmanWrapper() {
        try {
            FileUtils.copyURLToFile(getInternalWrapperUrl(), getWrapper());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private URL getInternalWrapperUrl() {
        URL wrapperScriptResource = this.getClass().getResource(getWrapperName());
        if (wrapperScriptResource == null) {
            throw new RuntimeException("could not get wrapper script resource");
        }
        return wrapperScriptResource;
    }

    @OutputFile
    public File getWrapper() {
        return getWrapperAbsolutePath();
    }
}
