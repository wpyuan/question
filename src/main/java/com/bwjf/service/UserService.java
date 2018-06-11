package com.bwjf.service;

import com.bwjf.entity.Problem;
import com.bwjf.entity.Respondent;

import java.util.List;

public interface UserService {
   public boolean commit(String answerList,Respondent respondent)throws Exception;
}
