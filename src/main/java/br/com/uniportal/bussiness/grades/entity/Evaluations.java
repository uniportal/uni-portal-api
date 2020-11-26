package br.com.uniportal.bussiness.grades.entity;

public class Evaluations {
    private String matter;
    private String grade;

    public Evaluations(String matter, String grade) {
        this.matter = matter;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public String getMatter() {
        return matter;
    }
}