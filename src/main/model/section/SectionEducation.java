package main.model.section;

import java.util.List;

public class SectionEducation implements Section {

    private List<Experience> experienceEducations;


    public SectionEducation(List<Experience> experienceEducations) {
        this.experienceEducations = experienceEducations;
    }


    public void addExperienceEducation(Experience experienceEducation) {
        experienceEducations.add(experienceEducation);
    }

    public List<Experience> getExperienceEducations() {
        return experienceEducations;
    }

    public void setExperienceEducations(List<Experience> experienceEducations) {
        this.experienceEducations = experienceEducations;
    }
}
