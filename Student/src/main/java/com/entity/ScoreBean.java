package com.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScoreBean {

    @ExcelProperty(value = "成绩id",index=0)
    private int scoreId;
    @ExcelProperty(value = "学生id",index=1)
    private Integer studentId;

    private String subjectName;

    private String studentName;

    @ExcelProperty(value = "成绩",index=3)
    private String score;
    @ExcelProperty(value = "课程id",index=2)
    private int subjectId;

    private String teacherName;

    private String subjectCredit;

    private int page;

    public ScoreBean(int scoreId, Integer studentId, String score, int subjectId) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;

    }
}
