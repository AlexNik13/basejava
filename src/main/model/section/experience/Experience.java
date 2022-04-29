package main.model.section.experience;

import java.io.Serializable;
import java.time.LocalDate;

public class Experience implements Serializable {

    private LocalDate startDate;
    private LocalDate finishDate;
    private String position;
    private Long nameLinkId;

    public Experience(LocalDate startDate, LocalDate finishDate, String position, Long nameLinkId) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.position = position;
        this.nameLinkId = nameLinkId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getNameLinkId() {
        return nameLinkId;
    }

    public void setNameLinkId(Long nameLinkId) {
        this.nameLinkId = nameLinkId;
    }
}
