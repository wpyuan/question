package com.bwjf.entity;

import java.util.Date;

/**
 * 问卷调查表实体类
 */
public class Questionnaire {
    private String no;
    private String title;
    private String state;
    private String createTime;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "no='" + no + '\'' +
                ", title='" + title + '\'' +
                ", state='" + state + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
