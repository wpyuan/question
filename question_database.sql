-----------------------------------------------------
-- Export file for user QUESTION                   --
-- Created by Administrator on 2018/6/14, 14:55:48 --
-----------------------------------------------------

spool question_database.log

prompt
prompt Creating table ANSWER
prompt =====================
prompt
create table QUESTION.ANSWER
(
  NO           VARCHAR2(10) not null,
  PROBLEMID    VARCHAR2(10) not null,
  RESPONDENTNO VARCHAR2(10) not null,
  OPTIONSID    VARCHAR2(10) not null,
  CONTENT      VARCHAR2(2000),
  ANSWERTIME   DATE default sysdate
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column QUESTION.ANSWER.NO
  is '答题表主键';
comment on column QUESTION.ANSWER.PROBLEMID
  is '问题id。对应PROBLEM表主键id';
comment on column QUESTION.ANSWER.RESPONDENTNO
  is '答题者编号。对应RESPONDENT表主键no';
comment on column QUESTION.ANSWER.OPTIONSID
  is '选项id。对应OPTIONS表主键id';
comment on column QUESTION.ANSWER.CONTENT
  is '答案内容';
comment on column QUESTION.ANSWER.ANSWERTIME
  is '回答时间';
alter table QUESTION.ANSWER
  add primary key (NO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CODE
prompt ===================
prompt
create table QUESTION.CODE
(
  NO              VARCHAR2(10) not null,
  QUESTIONNAIRENO VARCHAR2(10) not null,
  CONTENT         CLOB,
  UPDATETIME      DATE default sysdate
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column QUESTION.CODE.NO
  is '网页代码主键';
comment on column QUESTION.CODE.QUESTIONNAIRENO
  is '显示是哪一张问卷。对应QUESTIONNAIRE表主键no';
comment on column QUESTION.CODE.CONTENT
  is '代码内容';
comment on column QUESTION.CODE.UPDATETIME
  is '更新时间';
alter table QUESTION.CODE
  add primary key (NO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OPTIONS
prompt ======================
prompt
create table QUESTION.OPTIONS
(
  ID         VARCHAR2(10) not null,
  PROBLEMID  VARCHAR2(10) not null,
  ROWNO      VARCHAR2(10) not null,
  COLNO      VARCHAR2(10) not null,
  CONTENT    VARCHAR2(2000) not null,
  CREATETIME DATE default sysdate,
  STATE      VARCHAR2(2) default 1,
  TYPE       VARCHAR2(20) default 'radio'
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column QUESTION.OPTIONS.ID
  is '主键';
comment on column QUESTION.OPTIONS.PROBLEMID
  is '对应PROBLEM表主键id';
comment on column QUESTION.OPTIONS.ROWNO
  is '行号';
comment on column QUESTION.OPTIONS.COLNO
  is '列号';
comment on column QUESTION.OPTIONS.CONTENT
  is '选项内容';
comment on column QUESTION.OPTIONS.CREATETIME
  is '创建时间';
comment on column QUESTION.OPTIONS.STATE
  is '是否有效。1：有效（默认）；0：无效';
comment on column QUESTION.OPTIONS.TYPE
  is '选项控件类型。单选（默认）；多选；文本；文本区域';
alter table QUESTION.OPTIONS
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PROBLEM
prompt ======================
prompt
create table QUESTION.PROBLEM
(
  ID              VARCHAR2(10) not null,
  QUESTIONNAIRENO VARCHAR2(10) not null,
  RANK            VARCHAR2(10) not null,
  CONTENT         VARCHAR2(2000) not null,
  CREATETIME      DATE default sysdate,
  STATE           VARCHAR2(2) default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column QUESTION.PROBLEM.ID
  is '主键';
comment on column QUESTION.PROBLEM.QUESTIONNAIRENO
  is '对应QUESTIONNAIRE表主键NO';
comment on column QUESTION.PROBLEM.RANK
  is '序号。指顺数第几题';
comment on column QUESTION.PROBLEM.CONTENT
  is '题干内容';
comment on column QUESTION.PROBLEM.CREATETIME
  is '创建时间';
comment on column QUESTION.PROBLEM.STATE
  is '是否有效。1：有效（默认）；0：无效';
alter table QUESTION.PROBLEM
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table QUESTIONNAIRE
prompt ============================
prompt
create table QUESTION.QUESTIONNAIRE
(
  NO         VARCHAR2(10) not null,
  TITLE      VARCHAR2(2000),
  STATE      VARCHAR2(2) default 1 not null,
  CREATETIME DATE default sysdate
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column QUESTION.QUESTIONNAIRE.NO
  is '编号。指第几套卷子';
comment on column QUESTION.QUESTIONNAIRE.TITLE
  is '标题。如“优化版广西国税网上办税系统意见调查问卷”';
comment on column QUESTION.QUESTIONNAIRE.STATE
  is '是否有效。1：有效（默认）；0：无效';
comment on column QUESTION.QUESTIONNAIRE.CREATETIME
  is '创建时间';
alter table QUESTION.QUESTIONNAIRE
  add primary key (NO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table RESPONDENT
prompt =========================
prompt
create table QUESTION.RESPONDENT
(
  NO              VARCHAR2(10) not null,
  NAME            VARCHAR2(20) not null,
  ANSWERTIME      DATE default sysdate,
  QUESTIONNAIRENO VARCHAR2(10) not null,
  NSRSBH          VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column QUESTION.RESPONDENT.NO
  is '序号';
comment on column QUESTION.RESPONDENT.NAME
  is '填表人';
comment on column QUESTION.RESPONDENT.ANSWERTIME
  is '填表时间';
comment on column QUESTION.RESPONDENT.QUESTIONNAIRENO
  is '问卷编号。指哪一套问卷，对应QUESTIONNAIRE表主键no';
comment on column QUESTION.RESPONDENT.NSRSBH
  is '纳税人识别号';
alter table QUESTION.RESPONDENT
  add primary key (NO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence ANSWER_SEQ
prompt ============================
prompt
create sequence QUESTION.ANSWER_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 141
increment by 1
cache 20;

prompt
prompt Creating sequence CODE_SEQ
prompt ==========================
prompt
create sequence QUESTION.CODE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence OPTIONS_SEQ
prompt =============================
prompt
create sequence QUESTION.OPTIONS_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;

prompt
prompt Creating sequence PROBLEM_SEQ
prompt =============================
prompt
create sequence QUESTION.PROBLEM_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence QUESTIONNAIRE_SEQ
prompt ===================================
prompt
create sequence QUESTION.QUESTIONNAIRE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence RESPONDENT_SEQ
prompt ================================
prompt
create sequence QUESTION.RESPONDENT_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating trigger ANSWERPKAUTOINCREMENT
prompt ======================================
prompt
create or replace trigger QUESTION.answerPKAutoIncrement
before insert
on answer
for each row
begin
    -- 忽略手动插入主键
    :new.no := answer_seq.nextval;
end;
/

prompt
prompt Creating trigger CODEPKAUTOINCREMENT
prompt ====================================
prompt
create or replace trigger QUESTION.codePKAutoIncrement
before insert
on code
for each row
begin
    -- 忽略手动插入主键
    :new.no := code_seq.nextval;
end;
/

prompt
prompt Creating trigger OPTIONSPKAUTOINCREMENT
prompt =======================================
prompt
create or replace trigger QUESTION.optionsPKAutoIncrement
before insert
on options
for each row
begin
    -- 忽略手动插入主键
    :new.id := options_seq.nextval;
end;
/

prompt
prompt Creating trigger PROBLEMPKAUTOINCREMENT
prompt =======================================
prompt
create or replace trigger QUESTION.problemPKAutoIncrement
before insert
on problem
for each row
begin
    -- 忽略手动插入主键
    :new.id := problem_seq.nextval;
end;
/

prompt
prompt Creating trigger QUESTIONNAIREPKAUTOINCREMENT
prompt =============================================
prompt
create or replace trigger QUESTION.questionnairePKAutoIncrement
before insert
on questionnaire
for each row
begin
    -- 忽略手动插入主键
    :new.no := questionnaire_seq.nextval;
end;
/

prompt
prompt Creating trigger RESPONDENTPKAUTOINCREMENT
prompt ==========================================
prompt
create or replace trigger QUESTION.respondentPKAutoIncrement
before insert
on respondent
for each row
begin
    -- 忽略手动插入主键
    :new.no := respondent_seq.nextval;
end;
/


spool off
