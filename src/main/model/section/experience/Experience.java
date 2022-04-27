package main.model.section.experience;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

public class Experience implements Serializable {

    protected LocalDate startDate;
    protected LocalDate finishDate;
    protected String description;
    protected String organizationId;

    public Experience(LocalDate startDate, LocalDate finishDate, String description, String organizationId) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.organizationId = organizationId;
    }

    protected static String getKey(Map<String, Organization> organizations, Organization organization) {

        for (Map.Entry<String, Organization> o : organizations.entrySet()) {
            if (o.getValue().equals(organization)) {
                return o.getKey();
            }

        }
        return String.valueOf(organization.hashCode());
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
}
