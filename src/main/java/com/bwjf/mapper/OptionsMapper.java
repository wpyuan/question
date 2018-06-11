package com.bwjf.mapper;



import com.bwjf.entity.Options;
import com.bwjf.entity.Problem;

import java.util.List;

/**
 * 2018/6/5 持久层
 */
public interface OptionsMapper {
    public List<Options> getByProblemId(String problemId)throws Exception;
    public Options getById(String id)throws Exception;
}
