package com.bwjf.service;

import com.bwjf.entity.Options;


import java.util.List;

public interface OptionsService {
   public List<Options> getByProblemId(String problemId)throws Exception;
}
