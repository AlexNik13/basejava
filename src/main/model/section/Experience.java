package main.model.section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Experience implements Section {

    private List<Period> periods = new ArrayList<>();
    private String title;
    private String link;
    private String description;

    public Experience(LocalDate startDate, LocalDate finishDate, String title, String link, String description) {
        addPeriods(startDate, finishDate);
        this.title = title;
        this.link = link;
        this.description = description;
    }

    public void addPeriods(LocalDate startDate, LocalDate finishDate){
        Period period = new Period(startDate, finishDate);
        periods.add(period);
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
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
}
