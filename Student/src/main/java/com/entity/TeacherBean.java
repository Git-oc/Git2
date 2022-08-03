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
public class TeacherBean {

    @ExcelProperty(value = "教师id")
    private int teacherId;
    @ExcelProperty(value = "教师姓名")
    private String teacherName;
    @ExcelProperty(value = "教师性别")
    private String teacherSex;
    @ExcelProperty(value = "所在系部")
    private String teacherSystem;
    @ExcelProperty(value = "教师电话")
    private String teacherPhone;
    @ExcelProperty(value = "电子邮件")
    private String teacherEmail;

    private int Page;

    public TeacherBean(int teacherId, String teacherName, String teacherSex, String teacherSystem, String teacherPhone, String teacherEmail) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;
        this.teacherSystem = teacherSystem;
        this.teacherPhone = teacherPhone;
        this.teacherEmail = teacherEmail;
    }
}
