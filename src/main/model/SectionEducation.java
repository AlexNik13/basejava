package main.model;

import java.time.LocalDate;

public class SectionEducation extends Experience implements Print {

    public SectionEducation(LocalDate startDate, LocalDate finishDate, String title, String link, String description) {
        super(startDate, finishDate, title, link, description);
    }

    @Override
    public void print() {
        System.out.println(getStartDate() + " " + getFinishDate() + " " + getTitle());
        System.out.println(getDescription() + "\n");
    }
}
