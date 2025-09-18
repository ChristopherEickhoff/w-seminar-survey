package de.chris.w_seminar_survey.survey;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyResultService {

    private final SurveyResultRepository surveyResultRepository;

    public SurveyResultService(SurveyResultRepository surveyResultRepository) {
        this.surveyResultRepository = surveyResultRepository;
    }

    public void insertResult(SurveyResult surveyResult) {
        surveyResultRepository.save(surveyResult);
    }

    public List<SurveyResult> getAllResults() {
        return surveyResultRepository.findAll();
    }
}
