package main.model.section.experience;

import main.model.section.Section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionWork implements Section {

    private List<ExperienceWork> works;

    public SectionWork(List<ExperienceWork> works) {
        this.works = works;
    }

    public List<ExperienceWork> getWorks() {
        return works;
    }

    public void setWorks(List<ExperienceWork> works) {
        this.works = works;
    }
}

