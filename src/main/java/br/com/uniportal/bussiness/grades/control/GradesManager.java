package br.com.uniportal.bussiness.grades.control;

import br.com.uniportal.bussiness.grades.entity.Grade;
import br.com.uniportal.shared.api.error.UniPortalException;
import org.springframework.stereotype.Service;



@Service
public class GradesManager {
    
    private GradesRepository gradesRepository;

    public GradesManager(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    public Boolean insertGrade(Grade grade) {
        if (grade == null) {
            throw UniPortalException.ofValidation("Nota inválida.");
        }

        if (grade.getEvaluations() == null) {
            throw UniPortalException.ofValidation("Avaliações inválidas.");
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