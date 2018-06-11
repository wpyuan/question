package com.bwjf.mapper;



import com.bwjf.entity.Problem;

import java.util.List;

/**
 * 2018/6/5 持久层
 */
public interface ProblemMapper {
    public List<Problem> getByQuestionnaireNo(String questionnaireNo)throws Exception;

}
