package main.model.section.experience;

import java.io.Serializable;
import java.util.Objects;

public class Link implements Serializable {

    private final String title;
    private final String link;

    public Link(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link that = (Link) o;
        return Objects.equals(title, that.title) && Objects.equals(link, that.link);
    }
}
