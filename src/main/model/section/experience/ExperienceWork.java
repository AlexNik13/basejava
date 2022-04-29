package main.model.section.experience;

import java.time.LocalDate;

public class ExperienceWork extends Experience {

    private String description;

    public ExperienceWork(LocalDate startDate, LocalDate finishDate, String position, Long nameLinkId, String description) {
        super(startDate, finishDate, position, nameLinkId);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
