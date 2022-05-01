package main.model.section.experience;

import java.time.LocalDate;

public class ExperienceWork extends Experience {
    private String detail;

    public ExperienceWork(LocalDate startDate, LocalDate finishDate, Link link, String description, String detail) {
        super(startDate, finishDate, link, description);
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
