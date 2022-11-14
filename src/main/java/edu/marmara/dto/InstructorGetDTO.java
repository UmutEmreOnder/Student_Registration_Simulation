package edu.marmara.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class InstructorGetDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private List<String> presentedCourses;
    private Boolean isAdvisor;


    @Override
    public String toString() {
        return "InstructorGetDTO{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", presentedCourses=" + presentedCourses +
                ", isAdvisor=" + isAdvisor +
                '}';
    }

    public InstructorGetDTO() {
    }

    public InstructorGetDTO(UUID uuid, String name, String surname, String email, Date birthDate, List<String> presentedCourses, Boolean isAdvisor) {
        this.uuid = uuid;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.presentedCourses = presentedCourses;
        this.isAdvisor = isAdvisor;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getPresentedCourses() {
        return presentedCourses;
    }

    public void setPresentedCourses(List<String> presentedCourses) {
        this.presentedCourses = presentedCourses;
    }

    public Boolean getAdvisor() {
        return isAdvisor;
    }

    public void setAdvisor(Boolean advisor) {
        isAdvisor = advisor;
    }
}
