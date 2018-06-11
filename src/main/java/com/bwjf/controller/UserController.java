package com.bwjf.controller;

import com.alibaba.fastjson.JSONObject;
import com.bwjf.entity.*;
import com.bwjf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 普通用户控制层
 * 1.填写问卷
 */
@Controller
public class UserController {
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private ProblemService problemService;
    @Autowired
    private OptionsService optionsService;
    @Autowired
    private UserService userService;
    @Autowired
    private RespondentService respondentService;

    /**
     * 显示调查问卷
     * @param model，questionnaireId问卷编号
     * @return main.html
     */
    @RequestMapping("/show")
    public String hello(Model model,String questionnaireNo){
        System.out.println("----show---");
        //1.根据questionnaireNo获取调查问卷
        String questionnaire = null;
        Questionnaire questionnaire1 = new Questionnaire();
        if(questionnaireNo==null){ //如果questionnaireNo为空，则写死这套问卷
            questionnaire = "优化版广西国税网上办税系统意见调查问卷";
            try {
                questionnaire1 = questionnaireService.getByTitle(questionnaire);
            } catch (Exception e) {
                System.out.println("异常代码：00000。查询数据库questionnaire表异常！");
                e.printStackTrace();
            }
        }else {//根据questionnaireNo获取调查问卷
            try {
                questionnaire1 = questionnaireService.getByNo(questionnaireNo);
            } catch (Exception e) {
                System.out.println("异常代码：00001。查询数据库questionnaire表异常！");
                e.printStackTrace();
            }
        }
        //2.获取题干
        List<Problem> problems = new ArrayList<>();
        try {
            problems = problemService.getByQuestionnaireNo(questionnaire1.getNo());
        } catch (Exception e) {
            System.out.println("异常代码：00002。查询数据库Problem表异常！");
            e.printStackTrace();
        }
        //3.获取选项
        List<Options> optionAll = new ArrayList<>();
        List<Options> options = new ArrayList<>();
        for (Problem p:problems) {
            try {
                //System.out.println("pid="+p.getId());
                options = optionsService.getByProblemId(p.getId());
                /*System.out.println("OPtions:-->");
                for (Options o:options
                        ) {
                    System.out.println(o.toString());
                }
                System.out.println("<--OPtions:end");
                */
                optionAll.addAll(options);
            } catch (Exception e) {
                System.out.println("异常代码：00003。查询数据库Options表异常！");
                e.printStackTrace();
            }
        }
        /*System.out.println("OPtionAll:-->");
        for (Options o:optionAll
             ) {
            System.out.println(o.toString());
        }
        System.out.println("<--OPtionAll:end");
        */
        model.addAttribute("questionnaire",questionnaire1);
        model.addAttribute("problems",problems);
        model.addAttribute("optionAll",optionAll);
        return "/pages/main";
    }

    /**
     * 提交问卷
     * @param
     * @return
     */
    @RequestMapping("/sumbit")
    @ResponseBody
    public String sumbit(String answerList,String questionnaireNo){
        System.out.println("----sumbit---");
        //System.out.println("answerList:"+answerList.toString());
        //System.out.println(questionnaireNo);
        Respondent respondent = new Respondent();
        respondent.setName("测试用户");
        respondent.setQuestionnaireNo(questionnaireNo);
        respondent.setNsrsbh("123456");
        try {
            respondentService.add(respondent);
        } catch (Exception e) {
            System.out.println("异常代码：00004。插入数据库respondent表异常！");
            e.printStackTrace();
        }
        try {
            boolean flag = userService.commit(answerList,respondent);
        } catch (Exception e) {
            System.out.println("异常代码：00005。插入数据库answer表异常！");
            e.printStackTrace();
        }

        return "提交成功";
    }

}
