package com.bwjf.entity;

import java.util.Date;

/**
 * 题干表实体类
 */
public class Problem {
    private String id;
    private String questionnaireNo;
    private String rank;
    private String content;
    private String createTime;
    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionnaireNo() {
        return questionnaireNo;
    }

    public void setQuestionnaireNo(String questionnaireNo) {
        this.questionnaireNo = questionnaireNo;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id='" + id + '\'' +
                ", questionnaireNo='" + questionnaireNo + '\'' +
                ", rank='" + rank + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
