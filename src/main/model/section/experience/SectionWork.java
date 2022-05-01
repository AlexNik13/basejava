package main.model.section.experience;

import main.model.section.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionWork implements Section {
    private List<ExperienceWork> experienceWorks = new ArrayList<>();

    public SectionWork(List<ExperienceWork> experienceWorks) {
        this.experienceWorks = experienceWorks;
    }

    public List<ExperienceWork> getExperienceWorks() {
        return experienceWorks;
    }

    public void setExperienceWorks(List<ExperienceWork> experienceWorks) {
        this.experienceWorks = experienceWorks;
    }
}

