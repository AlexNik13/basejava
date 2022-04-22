package main.model.section;

import java.util.List;

public class SectionWork implements Section {

    private List<ExperienceWork> experienceExperienceWorks;

    public SectionWork(List<ExperienceWork> experienceExperienceWorks) {
        this.experienceExperienceWorks = experienceExperienceWorks;
    }

    public void addExperienceWorks(ExperienceWork experienceWork) {
        experienceExperienceWorks.add(experienceWork);
    }

    public List<ExperienceWork> getExperienceExperienceWorks() {
        return experienceExperienceWorks;
    }

    public void setExperienceExperienceWorks(List<ExperienceWork> experienceExperienceWorks) {
        this.experienceExperienceWorks = experienceExperienceWorks;
    }
}

