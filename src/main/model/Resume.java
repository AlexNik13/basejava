package main.model;

import main.mapper.GsonPrintMapper;
import main.model.section.Section;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Resume implements Comparable<Resume> {

    private String uuid;
    private String fullName;

    private Map<Enum<?>, Section> sections = new HashMap<>();

    public Resume() {
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public void printContactOrSection(Enum<?> section) {
        Object o = sections.get(section);
        System.out.println(GsonPrintMapper.toGson(o));
    }

    public void printResume() {
        System.out.println(GsonPrintMapper.toGson(this));
    }

    public void addSection(Enum<?> enumType, Section section) {
        sections.put(enumType, section);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Map<Enum<?>, Section> getSections() {
        return sections;
    }

    public void setSections(Map<Enum<?>, Section> sections) {
        this.sections = sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume resume) {
        if (resume.toString().equals(uuid)) return 0;
        int comp = resume.toString().compareTo(uuid);
        return comp > 0 ? -1 : 1;
    }
}
