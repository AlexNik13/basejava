package main.model;

import java.time.LocalDate;

public abstract class Experience {
    private LocalDate startDate;
    private LocalDate finishDate;
    private String title;
    private String titleLink;
    private String description;

    protected Experience(LocalDate startDate, LocalDate finishDate, String title, String titleLink, String description) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.title = title;
        this.titleLink = titleLink;
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitleLink() {
        return titleLink;
    }

    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }
}
