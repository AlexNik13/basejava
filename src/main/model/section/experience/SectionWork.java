package main.model.section.experience;

import main.model.section.Section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionWork implements Section {

    private List<ExperienceWork> experienceWorks = new ArrayList<>();
    private Map<String, Organization> organizations = new HashMap<>();

    public void addWorkExperience(LocalDate startDate, LocalDate finishDate, String title, String link, String description, String detail) {
        Organization organization = new Organization(title, link);
        String key = Experience.getKey(organizations, organization);
        organizations.put(key, organization);
        experienceWorks.add(new ExperienceWork(startDate, finishDate, description, key, detail));
    }

    public List<ExperienceWork> getExperienceWorks() {
        return experienceWorks;
    }

    public void setExperienceWorks(List<ExperienceWork> experienceWorks) {
        this.experienceWorks = experienceWorks;
    }

    public Map<String, Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Map<String, Organization> organizations) {
        this.organizations = organizations;
    }
}

