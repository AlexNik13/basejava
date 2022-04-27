package main.model.section.experience;

import java.io.Serializable;
import java.util.Objects;

public class Organization implements Serializable {

    private String title;
    private String link;

    public Organization(String title, String link) {
        this.title = title;
        this.link = link;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(title, that.title) && Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, link);
    }
}
