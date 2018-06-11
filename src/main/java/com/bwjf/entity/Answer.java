package com.bwjf.entity;

import java.util.Date;

/**
 * 答题表实体类
 */
public class Answer {
    private String no;
    private String problemId;
    private String respondentNo;

    public String getOptionsId() {
        return optionsId;
    }

    public void setOptionsId(String optionsId) {
        this.optionsId = optionsId;
    }

    private String optionsId;
    private String content;
    private Date answerTime;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getRespondentNo() {
        return respondentNo;
    }

    public void setRespondentNo(String respondentNo) {
        this.respondentNo = respondentNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "no='" + no + '\'' +
                ", problemId='" + problemId + '\'' +
                ", respondentNo='" + respondentNo + '\'' +
                ", optionsId='" + optionsId + '\'' +
                ", content='" + content + '\'' +
                ", answerTime=" + answerTime +
                '}';
    }
}
