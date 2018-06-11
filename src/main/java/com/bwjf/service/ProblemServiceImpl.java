package com.bwjf.service;

import com.bwjf.entity.Problem;
import com.bwjf.mapper.ProblemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class ProblemServiceImpl implements ProblemService {
    @Resource
    private ProblemMapper problemMapper;

    @Override
    public List<Problem> getByQuestionnaireNo(String questionnaireNo) throws Exception {
        return problemMapper.getByQuestionnaireNo(questionnaireNo);
    }
}
