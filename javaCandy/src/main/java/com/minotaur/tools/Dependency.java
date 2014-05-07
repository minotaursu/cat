package com.minotaur.tools;

import java.util.List;

/**
 * Created by xu.sux on 14-2-27.
 */
public class Dependency {

    private String artifactId;

    private String groupId;

    private String version;

    private List<Excludes> excludesList;

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Excludes> getExcludesList() {
        return excludesList;
    }

    public void setExcludesList(List<Excludes> excludesList) {
        this.excludesList = excludesList;
    }
}
