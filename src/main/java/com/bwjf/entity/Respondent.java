package com.bwjf.entity;

import java.util.Date;

/**
 * 填表人表实体类
 */
public class Respondent {
    private String no;
    private String name;
    private String answerTime;
    private String questionnaireNo;
    private String nsrsbh;

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    public String getQuestionnaireNo() {
        return questionnaireNo;
    }

    public void setQuestionnaireNo(String questionnaireNo) {
        this.questionnaireNo = questionnaireNo;
    }

    @Override
    public String toString() {
        return "Respondent{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", answerTime='" + answerTime + '\'' +
                ", questionnaireNo='" + questionnaireNo + '\'' +
                ", nsrsbh='" + nsrsbh + '\'' +
                '}';
    }
}
