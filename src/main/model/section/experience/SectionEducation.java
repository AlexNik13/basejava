package main.model.section.experience;

import main.model.section.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionEducation implements Section {

    private List<Experience> experienceEducations = new ArrayList<>();

    public SectionEducation(List<Experience> experienceEducations) {
        this.experienceEducations = experienceEducations;
    }

    public List<Experience> getExperienceEducations() {
        return experienceEducations;
    }

    public void setExperienceEducations(List<Experience> experienceEducations) {
        this.experienceEducations = experienceEducations;
    }
}
