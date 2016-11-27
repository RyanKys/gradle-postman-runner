package de.infonautika.postman.settings;

import org.gradle.api.file.FileTree;

import java.io.File;

public class PreferredSettings implements NewmanSettings {
    private NewmanSettings defaultSettings;
    private FileTree collections;
    private File environment;
    private Boolean cliReport;
    private String xmlReportDir;
    private Boolean stopOnError;

    public PreferredSettings(NewmanSettings defaultSettings) {
        this.defaultSettings = defaultSettings;
    }

    @Override
    public FileTree getCollections() {
        if (collections == null) {
            return defaultSettings.getCollections();
        }
        return collections;
    }

    @Override
    public File getEnvironment() {
        if (environment == null) {
            return defaultSettings.getEnvironment();
        }
        return environment;
    }

    @Override
    public boolean getCliReport() {
        if (cliReport == null) {
            return defaultSettings.getCliReport();
        }
        return cliReport;
    }

    @Override
    public String getXmlReportDir() {
        if (xmlReportDir == null) {
            return defaultSettings.getXmlReportDir();
        }
        return xmlReportDir;
    }

    @Override
    public boolean getStopOnError() {
        if (stopOnError == null) {
            return defaultSettings.getStopOnError();
        }
        return stopOnError;
    }

    public void setCollections(FileTree collections) {
        this.collections = collections;
    }

    public void setEnvironment(File environment) {
        this.environment = environment;
    }

    public void setCliReport(boolean cliReport) {
        this.cliReport = cliReport;
    }

    public void setXmlReportDir(String xmlReportDir) {
        this.xmlReportDir = xmlReportDir;
    }

    public void setStopOnError(boolean stopOnError) {
        this.stopOnError = stopOnError;
    }
}
