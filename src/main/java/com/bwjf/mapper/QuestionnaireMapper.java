package com.bwjf.mapper;

import com.bwjf.entity.Questionnaire;

import java.util.List;

/**
 * 2018/6/1 持久层
 */
public interface QuestionnaireMapper {
    public List<Questionnaire> getAll()throws Exception;
    public Questionnaire getByNo(String questionnaireNo)throws Exception;
    public Questionnaire getByTitle(String title)throws Exception;
}
