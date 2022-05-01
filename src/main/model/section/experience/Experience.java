package main.model.section.experience;

import java.io.Serializable;
import java.time.LocalDate;

public class Experience implements Serializable {

    private LocalDate startDate;
    private LocalDate finishDate;
    private Link link;
    private String description;

    public Experience(LocalDate startDate, LocalDate finishDate, Link link, String description) {
        this.startDate = startDate;
        this.finishDate = finishDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
