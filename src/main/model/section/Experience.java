package main.model.section;

import java.time.LocalDate;

public class Experience implements Section {
    private LocalDate startDate;
    private LocalDate finishDate;
    private String title;
    private String link;
    private String description;

    public Experience(LocalDate startDate, LocalDate finishDate, String title, String link, String description) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.title = title;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
