package Bai13.entity;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee{
    private LocalDate graduationDate;
    private String graduationRank;
    private  String education;
    public Fresher(){};

    public Fresher(LocalDate graduationDate, String graduationRank, String education){
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher(String id, String fullName, LocalDate birthday, String phone, List<Certificate> certificates, LocalDate graduationDate, String graduationRank, String education){
        super(id, fullName, birthday, phone, certificates);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void showInformation() {
        System.out.println("Fresher{" +
                ", id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", certificates=" + certificates +
                ", graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
                '}');
    }
}
