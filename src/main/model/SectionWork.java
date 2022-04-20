package main.model;

import java.time.LocalDate;

public class SectionWork extends Experience {

    private String detail;

    public SectionWork(LocalDate startDate, LocalDate finishDate, String title, String link, String description, String detail) {
        super(startDate, finishDate, title, link, description);
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public void print() {
        System.out.println(getStartDate() + " " + getFinishDate() + " " + getTitle());
        System.out.println(getDescription());
        System.out.println(detail + "\n");
    }
}
