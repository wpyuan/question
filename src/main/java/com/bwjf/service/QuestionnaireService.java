package com.bwjf.service;

import com.bwjf.entity.Questionnaire;

import java.util.List;

public interface QuestionnaireService {
    public List<Questionnaire> getAll()throws Exception;
    public Questionnaire getByNo(String questionnaireNo)throws Exception;
    public Questionnaire getByTitle(String title)throws Exception;
}
