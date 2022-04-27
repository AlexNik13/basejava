package main.model.section.experience;

import java.time.LocalDate;

public class ExperienceWork extends Experience {
    protected String detail;

    public ExperienceWork(LocalDate startDate, LocalDate finishDate, String description, String organizationId, String detail) {
        super(startDate, finishDate, description, organizationId);
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
