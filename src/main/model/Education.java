package main.model;

import java.time.LocalDate;

public class Education extends Experience{

    public Education(LocalDate startDate, LocalDate finishDate, String title, String titleLink, String description) {
        super(startDate, finishDate, title, titleLink, description);
    }
}
