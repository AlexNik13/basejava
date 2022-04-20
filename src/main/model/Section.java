package main.model;

import java.util.ArrayList;
import java.util.List;

public class Section implements Print {
    private List<String> descriptions = new ArrayList<>();

    public Section() {
    }

    public Section(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public void addDescription(String description) {
        descriptions.add(description);
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public void print() {
        for (String s : descriptions) {
            System.out.println(s);
        }
    }
}
