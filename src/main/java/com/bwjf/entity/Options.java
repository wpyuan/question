package com.bwjf.entity;

import java.util.Date;

/**
 * 选项表实体类
 */
public class Options {
    private String id;
    private String problemId;
    private String rowNo;
    private String colNo;
    private String content;
    private String createTime;
    private String state;
    private String type;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getRowNo() {
        return rowNo;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    public String getColNo() {
        return colNo;
    }

    public void setColNo(String colNo) {
        this.colNo = colNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Options{" +
                "id='" + id + '\'' +
                ", problemId='" + problemId + '\'' +
                ", rowNo='" + rowNo + '\'' +
                ", colNo='" + colNo + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
