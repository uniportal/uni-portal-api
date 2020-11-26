package br.com.uniportal.bussiness.grades.control;

import br.com.uniportal.bussiness.grades.entity.Evaluations;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.uniportal.bussiness.grades.entity.Grade;
import br.com.uniportal.shared.api.error.UniPortalException;

@Service
public class GradesManager {
    
    private GradesRepository gradesRepository;

    public GradesManager(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    public Boolean insertGrade(String document, String matter1, String grade1, String matter2, String grade2, String matter3, String grade3, String matter4, String grade4, String matter5, String grade5) {
        Grade grade = new Grade();
        grade.setUserDocument(document);
        grade.setEvaluations(new LinkedList<Evaluations>());
        grade.getEvaluations().add(0, new Evaluations(matter1, grade1));
        grade.getEvaluations().add(1, new Evaluations(matter2, grade2));
        grade.getEvaluations().add(2, new Evaluations(matter3, grade3));
        grade.getEvaluations().add(3, new Evaluations(matter4, grade4));
        grade.getEvaluations().add(4, new Evaluations(matter5, grade5));
        
        if (grade == null) {
            throw UniPortalException.ofValidation("Nota inválida.");
        }

        grade.validate();

        return gradesRepository.insertGrade(grade);
    }

    public Grade getUsersGradesByDocument(String document) {
        if (document == null) {
            throw UniPortalException.ofValidation("Usuário inválido.");
        }
        return gradesRepository.getUsersGradesByDocument(document);
    }
}