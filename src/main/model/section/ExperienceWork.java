package main.model.section;

import java.time.LocalDate;

public class ExperienceWork extends Experience {
    private String detail;

    public ExperienceWork(LocalDate startDate, LocalDate finishDate, String title, String link, String description, String detail) {
        super(startDate, finishDate, title, link, description);
        this.detail = detail;
    }
}
