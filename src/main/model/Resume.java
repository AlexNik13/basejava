package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private String fullName;
    private String phone;
    private String skype;
    private String email;
    private Map<String, String> socialLinks;
    private String position;
    private String personalQualities;
    private List<String> achievements = new ArrayList<>();
    private List<String> qualifications = new ArrayList<>();
    private List<Work> experienceWorks = new ArrayList<>();
    private List<Education> educations = new ArrayList<>();

    public Resume() {
    }

    public Resume(String uuid) {
        this.uuid = uuid;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(Map<String, String> socialLinks) {
        this.socialLinks = socialLinks;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPersonalQualities() {
        return personalQualities;
    }

    public void setPersonalQualities(String personalQualities) {
        this.personalQualities = personalQualities;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }

    public List<Work> getExperienceWorks() {
        return experienceWorks;
    }

    public void setExperienceWorks(List<Work> experienceWorks) {
        this.experienceWorks = experienceWorks;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
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
