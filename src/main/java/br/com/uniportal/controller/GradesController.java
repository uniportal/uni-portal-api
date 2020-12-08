package br.com.uniportal.controller;

import br.com.uniportal.bussiness.grades.control.GradesManager;
import br.com.uniportal.bussiness.grades.entity.Grade;
import br.com.uniportal.shared.api.controller.BaseController;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("grades")
public class GradesController extends BaseController {
    
    private GradesManager gradesManager;

    public GradesController(Executor executor, GradesManager gradesManager) {
        super(executor);
        this.gradesManager = gradesManager;
    }   

    @PostMapping()
    public CompletableFuture<Boolean> insertGrade(@RequestBody Grade grade) { 
        return asyncResultOf(() -> (Boolean) this.gradesManager.insertGrade(grade));
    }

    @GetMapping("{document}")
    public CompletableFuture<Grade> getUsersGradesByDocument(@PathVariable String document) {
        return asyncResultOf(() -> (Grade) this.gradesManager.getUsersGradesByDocument(document));
    }
}