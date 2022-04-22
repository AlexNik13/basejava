package main.model.section;

import java.util.List;

public class AchievementOrQualifications implements Section {

    private String sectionType;
    private List<String> content;

    public AchievementOrQualifications(String sectionType, List<String> content) {
        this.sectionType = sectionType;
        this.content = content;
    }

    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
