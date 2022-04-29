package main.model.section.experience;

import main.model.section.Section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionEducation implements Section {

    private List<Experience> sectionEducation ;

    public SectionEducation(List<Experience> sectionEducation) {
        this.sectionEducation = sectionEducation;
    }

    public List<Experience> getSectionEducation() {
        return sectionEducation;
    }

    public void setSectionEducation(List<Experience> sectionEducation) {
        this.sectionEducation = sectionEducation;
    }
}
