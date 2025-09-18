package de.chris.w_seminar_survey.survey;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class SurveyController {

    private final SurveyResultService surveyResultService;

    public SurveyController(SurveyResultService surveyResultService) {
        this.surveyResultService = surveyResultService;
    }

    //TODO: Vercel
    //TODO: Docker
    
    @PostMapping("/api/submit")
    @ResponseBody
    public void submitForm(@RequestBody SurveyResult result) {
        surveyResultService.insertResult(result);
        
    }

    @GetMapping("/api/results")
    public List<SurveyResult> getAllResults() {
        return surveyResultService.getAllResults();
    }

    //TODO: Swagger
}
