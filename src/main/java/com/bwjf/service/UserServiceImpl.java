package com.bwjf.service;

import com.alibaba.fastjson.JSONObject;
import com.bwjf.entity.Answer;
import com.bwjf.entity.Options;
import com.bwjf.entity.Respondent;
import com.bwjf.mapper.AnswerMapper;
import com.bwjf.mapper.OptionsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private AnswerMapper answerMapper;
    @Resource
    private OptionsMapper optionsMapper;

    @Override
    public boolean commit(String answerList,Respondent respondent) throws Exception {
        JSONObject json=JSONObject.parseObject(answerList);
        //System.out.println(answerList.toString());
        int size = json.size();
        Answer answer = null;
        for (int i = 0; i < size; i++){
            JSONObject jsonObject = (JSONObject) json.get(""+i);
            Iterator sIterator = jsonObject.entrySet().iterator();
            while(sIterator.hasNext()){
                // 获得key
                Map.Entry keyValue = (Map.Entry) sIterator.next();
                // 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可
                //System.out.println("key: "+key.getKey()+",value:"+key.getValue());
                answer = new Answer();
                answer.setProblemId(optionsMapper.getById((String) keyValue.getKey()).getProblemId());
                answer.setRespondentNo(respondent.getNo());
                answer.setOptionsId((String) keyValue.getKey());
                answer.setContent((String) keyValue.getValue());
                answerMapper.insert(answer);
            }
        }
        return true;
    }
}
