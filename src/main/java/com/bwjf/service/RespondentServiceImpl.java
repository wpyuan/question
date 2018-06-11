package com.bwjf.service;

import com.bwjf.entity.Respondent;
import com.bwjf.mapper.RespondentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class RespondentServiceImpl implements RespondentService {

    @Resource
    private RespondentMapper respondentMapper;

    @Override
    public void add(Respondent respondent) throws Exception {
        System.out.println(respondent.toString());

        respondentMapper.add(respondent);
    }
}
