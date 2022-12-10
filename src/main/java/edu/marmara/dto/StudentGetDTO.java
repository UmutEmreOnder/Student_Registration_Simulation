package edu.marmara.dto;


import java.util.Date;
import java.util.UUID;

public class StudentGetDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private Long studentId;
    private Integer yearEnrolled;
    private String advisor;
    private Integer semester;

    public StudentGetDTO() {
    }

    public StudentGetDTO(UUID uuid, String name, String surname, String email, Date birthDate, Long studentId, Integer yearEnrolled, String advisor, Integer semester) {
        this.uuid = uuid;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.studentId = studentId;
        this.yearEnrolled = yearEnrolled;
        this.advisor = advisor;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "StudentGetDTO{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", studentId=" + studentId +
                ", yearEnrolled=" + yearEnrolled +
                ", advisor='" + advisor + '\'' +
                ", semester=" + semester +
                '}';
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getYearEnrolled() {
        return yearEnrolled;
    }

    public void setYearEnrolled(Integer yearEnrolled) {
        this.yearEnrolled = yearEnrolled;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
