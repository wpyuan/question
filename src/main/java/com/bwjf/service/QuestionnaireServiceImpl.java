package com.bwjf.service;

import com.bwjf.entity.Questionnaire;
import com.bwjf.mapper.QuestionnaireMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Resource
    private QuestionnaireMapper questionnaireMapper;
    @Override
    public List<Questionnaire> getAll() throws Exception {
        return questionnaireMapper.getAll();
    }

    @Override
    public Questionnaire getByNo(String questionnaireNo) throws Exception {

        return questionnaireMapper.getByNo(questionnaireNo);
    }

    @Override
    public Questionnaire getByTitle(String title) throws Exception {
        return questionnaireMapper.getByTitle(title);
    }
}
