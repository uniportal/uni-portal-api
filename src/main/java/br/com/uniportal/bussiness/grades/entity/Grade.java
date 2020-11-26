package br.com.uniportal.bussiness.grades.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class Grade {
    private UUID id;
    private String userDocument;
    private List<Evaluations> evaluations;

    public UUID getId() {
        return id;
    }
    public String getUserDocument() {
        return userDocument;
    }
    public List<Evaluations> getEvaluations() {
        return evaluations;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public void setEvaluations(List<Evaluations> evaluations) {
        this.evaluations = evaluations;
    }

    public void validate() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
