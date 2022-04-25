package main.model.section;

public class PositionOrQualities implements Section {
    private String description;

    public PositionOrQualities(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
