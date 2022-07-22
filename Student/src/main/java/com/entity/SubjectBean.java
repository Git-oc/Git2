package com.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubjectBean {

    @ExcelProperty(value = "课程编号")
    private int subjectId;
    @ExcelProperty(value = "课程名称")
    private String subjectName;
    @ExcelProperty(value = "授课教师")
    private String teacherName;
    @ExcelProperty(value = "课程学分")
    private String subjectCredit;

    private int page;

    public SubjectBean(int subjectId, String subjectName, String teacherName, String subjectCredit) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.subjectCredit = subjectCredit;
    }
}
