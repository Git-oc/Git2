package com.entity;

import lombok.Data;

@Data
public class ScoreBean {

    private int scoreId;
    private Integer studentId;
    private String subjectName;
    private String studentName;
    private String score;
    private int subjectId;
    private String teacherName;
    private String subjectCredit;
    private int page;

}
