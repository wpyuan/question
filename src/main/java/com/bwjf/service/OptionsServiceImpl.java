package com.bwjf.service;

import com.bwjf.entity.Options;
import com.bwjf.mapper.OptionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class OptionsServiceImpl implements OptionsService {
    @Resource
    private OptionsMapper optionsMapper;

    @Override
    public List<Options> getByProblemId(String problemId) throws Exception {
        return optionsMapper.getByProblemId(problemId);
    }
}
