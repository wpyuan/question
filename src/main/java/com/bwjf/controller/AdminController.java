package com.bwjf.controller;

import com.bwjf.entity.Questionnaire;
import com.bwjf.service.QuestionnaireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员控制层
 * 1.编辑问卷
 * 2.添加问卷
 * 3.删除问卷
 * 4.设置问卷失效
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private QuestionnaireService questionnaireService;
    /**
     * 添加问卷
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(Model model){
        System.out.println("--add---");
        return "/pages/Admin/add";
    }

    /**
     * 编辑问卷
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Model model){
        System.out.println("--edit---");
        List<Questionnaire> questionnaireList = new ArrayList<>();
        try {
            questionnaireList = questionnaireService.getAll();
            model.addAttribute("questionnaireList",questionnaireList);
        } catch (Exception e) {
            System.out.println("异常代码：00006。查询数据库questionnaire表异常！");
            e.printStackTrace();
        }
        return "/pages/Admin/edit";
    }

    /**
     * 预览问卷
     */
    @RequestMapping("/show")
    public String show(Model model){
        System.out.println("--show---");
        return "/pages/main";
    }
}
