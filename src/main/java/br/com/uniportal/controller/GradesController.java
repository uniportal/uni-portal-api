package br.com.uniportal.controller;

import br.com.uniportal.bussiness.grades.control.GradesManager;
import br.com.uniportal.bussiness.grades.entity.Grade;
import br.com.uniportal.shared.api.controller.BaseController;

import br.com.uniportal.shared.api.response.ApiReturn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;


@RestController
@RequestMapping("grades")
public class GradesController extends BaseController {
    
    private GradesManager gradesManager;

    public GradesController(Executor executor, GradesManager gradesManager) {
        super(executor);
        this.gradesManager = gradesManager;
    }   

    @PostMapping()
    public CompletableFuture<Boolean> insertGrade(@RequestParam String document, @RequestParam String matter1, @RequestParam String grade1, @RequestParam String matter2, @RequestParam String grade2, @RequestParam String matter3, @RequestParam String grade3, @RequestParam String matter4, @RequestParam String grade4, @RequestParam String matter5, @RequestParam String grade5) { 
        return asyncResultOf(() -> (Boolean) this.gradesManager.insertGrade(document, matter1, grade1, matter2, grade2, matter3, grade3, matter4, grade4, matter5, grade5));
    }

    @GetMapping("{document}")
    public CompletableFuture<Grade> getUsersGradesByDocument(@PathVariable String document) {
        return asyncResultOf(() -> (Grade) this.gradesManager.getUsersGradesByDocument(document));
    }
}