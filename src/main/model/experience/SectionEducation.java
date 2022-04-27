package main.model.experience;

import main.model.section.Section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionEducation implements Section {

    private List<Experience> experienceEducations = new ArrayList<>();
    private Map<String, Organization> organizations = new HashMap<>();

    public void addEducationExperience(LocalDate startDate, LocalDate finishDate, String title, String link, String description) {
        Organization organization = new Organization(title, link);
        String key = Experience.getKey(organizations, organization);
        organizations.put(key, organization);
        experienceEducations.add(new Experience(startDate, finishDate, description, key));
    }
}
