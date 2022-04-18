package main.model;

import java.time.LocalDate;

public class Work extends Experience{
    private String detail;

    public Work(LocalDate startDate, LocalDate finishDate, String title, String titleLink, String description, String detail) {
        super(startDate, finishDate, title, titleLink, description);
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
