package com.bwjf.service;

import com.bwjf.entity.Problem;
import com.bwjf.entity.Questionnaire;

import java.util.List;

public interface ProblemService {
   public List<Problem> getByQuestionnaireNo(String questionnaireNo)throws Exception;
}
